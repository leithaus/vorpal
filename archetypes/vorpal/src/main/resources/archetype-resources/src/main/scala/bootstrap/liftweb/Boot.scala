package bootstrap.liftweb

import _root_.net.liftweb.util._
import _root_.net.liftweb.common._
import _root_.net.liftweb.http._
import _root_.net.liftweb.http.provider._
import _root_.net.liftweb.http.provider.servlet._
import _root_.net.liftweb.sitemap._
import _root_.net.liftweb.sitemap.Loc._
import Helpers._
import _root_.net.liftweb.mapper.{DB, ConnectionManager, Schemifier, DefaultConnectionIdentifier, StandardDBVendor}
import _root_.java.sql.{Connection, DriverManager}
import _root_.java.util.UUID

import _root_.com.${package}.model._
import _root_.com.${package}.lib._
import _root_.com.${package}.snippet.Misc

import scala.collection.{Map, Set}
import scala.collection.mutable.{ListBuffer, ListMap}

import _root_.java.io._
import _root_.org.apache.commons.httpclient._
import _root_.org.apache.commons.httpclient.methods._
import _root_.org.apache.commons.fileupload
import _root_.org.apache.commons.fileupload._
import _root_.org.apache.commons.fileupload.servlet._
import _root_.org.apache.commons.fileupload.disk._

/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot
extends UUIDOps
with ScalaxbFileCompiler
with BNFCProjectBuilder {
  def boot {
    if (!DB.jndiJdbcConnAvailable_?) {
      val vendor = 
	new StandardDBVendor(Props.get("db.driver") openOr "org.h2.Driver",
			     Props.get("db.url") openOr 
			     "jdbc:h2:lift_proto.db;AUTO_SERVER=TRUE",
			     Props.get("db.user"), Props.get("db.password"))

      LiftRules.unloadHooks.append(vendor.closeAllConnections_! _)

      DB.defineConnectionManager(DefaultConnectionIdentifier, vendor)
    }

    // where to search snippet
    LiftRules.addToPackages("com.biosimilarity.lift")
    Schemifier.schemify(true, Schemifier.infoF _, User)

    // Build SiteMap
    def sitemap() = SiteMap(
      Menu("Home") / "index" :: // Simple menu form
      // Menu with special Link
      Menu(Loc("Static", Link(List("static"), true, "/static/index"), 
	       "Static Content")) ::
      Menu(Loc("REPLForm.1", List( "AJAXREPLForm" ), "R-E-P-L", If(User.loggedIn_? _, "x"))) ::
      Menu(Loc("GrammarSpec.1", List( "GrammarSpec" ), "Grammar", If(User.loggedIn_? _, "x"))) ::
      Menu(Loc("file_upload", List( "file_upload" ), "File Upload", If(User.loggedIn_? _, "x") )) ::
      // Menu entries for the User management stuff
      User.sitemap :_*)    
    
    case class CompilationResponse( inFileName : String, outFileName : String ) 
    
    def handleBNFCReq( req : Req, grammar : String ) = {
      val optFname : Option[String] = req.param( "file" ) 
      val fileParams : List[FileParamHolder] = req.uploadedFiles
      
      println( "fileParams is this long: " + fileParams.length )

      val arXivFiles : List[(java.io.File,java.io.InputStream)] =
	fileParams.map( fph => createProjectArxiv( fph ) )      
      val fstArXivFile = arXivFiles.head

      val rspHdrs : List[(String,String)] =
	List( 
	  ("Content-Type","application/zip"),	  
	  ("Content-Disposition",
	   "attachment; filename=" + fstArXivFile._1.getName)
	)

      () => {
	Full(
	  StreamingResponse(
	    fstArXivFile._2,
	    { () => { fstArXivFile._2.close } },
	    fstArXivFile._1.length,
	    rspHdrs,
	    List(),
	    200
	  )	  
	)
      }
    }

    def handleScalaXBReq( req : Req, grammar : String ) = {
      //println( "***** What is going on HERE *****" )
      val optFname : Option[String] = req.param( "file" ) 
      val fileParams : List[FileParamHolder] = req.uploadedFiles
      
      println( "fileParams is this long: " + fileParams.length )

      val scalaFiles : List[String] =
	fileParams.map( fph => scalaFile( fph ) )

      val responseStr : Option[String] = 
	Some( ( "" /: scalaFiles )( { ( acc, s ) => acc + "\n" + s } ) )

      () => {
	Full(
	  PlainTextResponse(
	    (grammar
	     + "?"
	     + (responseStr match { case Some( s ) => s; case _ => "" })
	     + "\n"),
	    List( "Content-Type" -> "text/plain; charset=UTF-8" ),
	    200
	  )
	)
      }
    }

    def dispatch: LiftRules.DispatchPF = {                        
      case req @ Req(
	List(
	  "biosimilarity-services",
	  "scalaxb",
	  grammar
	),
	"",
	PostRequest
      ) => { handleScalaXBReq( req, grammar ) }      
      case req @ Req(
	List(
	  "biosimilarity-services",
	  "bnfc",
	  grammar
	),
	"",
	PostRequest
      ) => { handleBNFCReq( req, grammar ) }
    }

    LiftRules.dispatch.prepend(dispatch)

    // PlainTextResponse(
//       ids.mkString("\n"),
//       List("Content-Type" -> "text/plain; charset=UTF-8"),
//       200
//     )

    LiftRules.setSiteMapFunc(sitemap)

    /*
     * Show the spinny image when an Ajax call starts
     */
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    /*
     * Make the spinny image go away when it ends
     */
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    LiftRules.early.append(makeUtf8)

    LiftRules.loggedInTest = Full(() => User.loggedIn_?)

    S.addAround(DB.buildLoanWrapper)
  }

  /**
   * Force the request to be UTF-8
   */
  private def makeUtf8(req: HTTPRequest) {
    req.setCharacterEncoding("UTF-8")
  }
}
