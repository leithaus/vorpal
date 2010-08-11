// -*- mode: Scala;-*- 
// Filename:    Valet.scala 
// Authors:     lgm                                                    
// Creation:    Fri Aug  6 20:23:25 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.model

import com.biosimilarity.lift.lib._

import scala.util.continuations._ 
import _root_.java.util.UUID

trait Valet {
  def projName             : String
  def deliverableStream(
    projID : UUID 
  ) :                        DeliveryStatus  
  def generateDTDFromCF    : Unit
  def generateXSDFromDTD   : Unit
  def generateScalaFromXSD : Unit
  def generateArxiv        : Unit
  def generateDeliverable(
    in : java.io.InputStream
  )                        : UUID
}

trait ProjectLayout {
  def workingDirName : String
  def projDirName    : String
  def scalaSrcFmt    : String

  def setUpWorkingDir( closeIn : Boolean, closeOut : Boolean)( fStream : java.io.InputStream ) : Unit
}

trait ScriptActions {
  def cf2dtdScript    = "../../bin/cf2dtd.sh"
  def fixdtdScript    = "../../bin/fixdtd.sh"
  def dtd2xsdScript   = "../../bin/dtd2xsd.sh"
  def xsd2scalaScript = "../../bin/xsd2scala.sh"
  def cleanScript     = "../../bin/clean.sh"
  def tidyScript      = "../../bin/tidy.sh"
  def arxivScript     = "bin/arxiv.sh"
}

trait Verbosity
case class Terse() extends Verbosity
case class Informative() extends Verbosity
case class Blogger() extends Verbosity

trait CmdStatus
case class RCnMsg( ec : Int, s : String )
extends CmdStatus

trait DeliveryStatus
case class FileNStream(
  file : java.io.File, stream : java.io.InputStream
) extends DeliveryStatus
case class DeliveryFailure(
  file : java.io.File
) extends DeliveryStatus

class VorpalValet(
  override val projName          : String,
  override val workingDirName    : String,
  override val projDirName       : String,
  override val scalaSrcFmt       : String,
  val          verbosity         : Verbosity
)
extends Valet
with ProjectLayout
with ScriptActions
with UUIDOps {
  import theSchemaCleaner._
  import Shell._

  lazy val owd   = new java.io.File( workingDirName )
  lazy val wd    = {
    val f = new java.io.File( owd, projName ); f.mkdir; f
  }
  lazy val projD = new java.io.File( projDirName )

  lazy val xsdFileName = 
    workingDirName + "/" + projName + "/" + projName + "p.xsd"
  lazy val xsdFixedFileName =
    workingDirName + "/" + projName + "/" + projName + ".xsd"
  lazy val cfFileName =
    workingDirName + "/" + projName + "/" + projName + ".cf"
  lazy val arXivFileName = projName + ".tgz"

  def report( ec : Int, s : String ) = {
    verbosity match {
      case Blogger() => {
	println( s + " : " + ec )
      }
      case Informative() => {
	println( s + " : " + ec )
      }
      case Terse() => {
      }
    }
  }

  def copyInToOut( closeIn : Boolean, closeOut : Boolean)(
    cfIn : java.io.InputStream,
    cfOut : java.io.OutputStream
  ) = {        
    // Transfer bytes from in to out
    val buf : Array[Byte] = new Array( 1024 )
    var len : Int = cfIn.read( buf )
    while (len > 0) {
      cfOut.write( buf, 0, len )
      len = cfIn.read( buf )
    }
    if ( closeIn ) cfIn.close()
    if ( closeOut ) cfOut.close()
  }

  def setUpWorkingDir( closeIn : Boolean, closeOut : Boolean)(
    cfIn : java.io.InputStream
  ) = {    
    copyInToOut( closeIn, closeOut)(
      cfIn,
      new java.io.FileOutputStream( cfFileName )
    )
  }  

  def deliverableStream( projID : UUID ) : DeliveryStatus = {    
    val projArXivName = projID.toString + ".tgz"
    val arXivFile = new java.io.File( projArXivName )
    var tries = 0
    def loop : DeliveryStatus = {
      if ( arXivFile.exists() ) {
	FileNStream(
	  arXivFile,
	  new java.io.FileInputStream( arXivFile )
	)
      }
      else {
	if ( tries < 10 ) {
	  tries += 1
	  Thread.sleep( 5000 )
	  loop
	} 	
	else {
	  DeliveryFailure( arXivFile )
	}
      }
    }
    loop
  }

  def generateDTDFromCF = {
    situatedCommand( wd )(
      cf2dtdScript, projName
    )(
      { ( ec, s ) => {
	report( ec, s );
	ec match {
	  case 0 => {
	    situatedCommand( wd )(
	      fixdtdScript, projName
	    )( { ( ec, s ) => { report( ec, s ) } } )
	  }
	  case _ => { }
	}
      }
     }
    )
  }
  def generateXSDFromDTD = {    
    situatedCommand( wd )(
      dtd2xsdScript, projName
    )(
      { ( ec, s ) => {
	report( ec, s );
	ec match {
	  case 0 => {
	    try {
	      cleanSchemaFile( xsdFileName, xsdFixedFileName )
	    }
	    catch {
	      case e => { e.printStackTrace }
	    }
	  }
	  case _ => { }
	}
      }
     }
    )
  }
  def generateScalaFromXSD = {
    situatedCommand( wd )(
      xsd2scalaScript, projName, scalaSrcFmt
    )(
      { ( ec, s ) => { report( ec, s ) }
     }
    )
  }
  def generateArxiv = {
    situatedCommand( wd )(
      cleanScript
    )(
      { ( ec, s ) => {
	report( ec, s );	
	ec match {
	  case 0 => {
	    situatedCommand( projD )(
	      arxivScript, projName, workingDirName
	    )( { ( ec, s ) => { report( ec, s ) } } );
	    ()
	  }
	  case _ => {  }
	}
      }
     }
    )
  }
  def generateDeliverable(
    in : java.io.InputStream
  ) : UUID = {
    val projID = getUUID()
    try {
      wd
      setUpWorkingDir( false, true )( in )
      situatedCommand( wd )(
	cf2dtdScript, projName
      )(
	{ ( ec, s ) => {
	  report( ec, "cf2dtdScript" + s );
	  ec match {
	    case 0 => {
	      situatedCommand( wd )(
		fixdtdScript, projName
	      )(
		{ ( ec, s ) => {
		  report( ec, "fixdtdScript" + s )
		  ec match {
		    case 0 => {
		      situatedCommand( wd )(
			dtd2xsdScript, projName
		      )(
			{ ( ec, s ) => {
			  report( ec, "dtd2xsdScript" + s );
			  ec match {
			    case 0 => {
			      try {
				cleanSchemaFile(
				  xsdFileName,
				  xsdFixedFileName
				)
				situatedCommand( wd )(
				  xsd2scalaScript, projName, scalaSrcFmt
				)(
				  { ( ec, s ) => {
				    report( ec, "xsd2scalaScript" + s )
				    ec match {
				      case 0 => {
					situatedCommand( wd )(
					  cleanScript
					)(
					  { ( ec, s ) => {
					    report( ec, "cleanScript"+ s );	
					    ec match {
					      case 0 => {
						situatedCommand( projD )(
						  arxivScript,
						  //projName,
						  projID.toString,
						  projName
						)(
						  { ( ec, s ) => {
						    report( ec, "arxivScript" +s )
						    ec match {
						      case 0 => {
							situatedCommand( wd )(
							  tidyScript,
							  projName
							)(
							  {
							    ( ec, s )
    => {
      report( ec, "tidyScript" +s )
    }
							  }
							)
						      }
						      case _ => { }
						    }
						  } } );
						()
					      }
					      case _ => {  }
					    }
					  }
					 }
					)
				      }
				    }
				  }
				 }
				)
			      }
			      catch {
				case e => { e.printStackTrace }
			      }
			    }
			    case _ => { }
			  }
			}
		       }
		      )
		    }
		    case _ => {
		    }
		  }
		}		
	       }
	      )
	    }
	    case _ => { }
	  }
	}
       }
      )
    }
    catch {
      case e => {
	e.printStackTrace
	throw e
      }
    }
    projID
  }
}
