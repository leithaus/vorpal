// -*- mode: Scala;-*- 
// Filename:    BNF2Squeryl.scala 
// Authors:     lgm                                                    
// Creation:    Wed Aug 11 22:54:47 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.model

import com.biosimilarity.lift.lib.UUIDOps
import com.biosimilarity.lift.model.vorpal._
import Absyn._

import org.squeryl._
//import org.squeryl.PrimitiveTypeMode._
import org.squeryl.customtypes.CustomTypesMode._
import org.squeryl.customtypes._
import org.squeryl.adapters.H2Adapter
import java.sql.{SQLException, Connection => SQLConnection}
import org.squeryl.dsl._

import scala.xml._
import scala.collection.mutable.Map

import java.net.URI
import _root_.java.util.UUID

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

trait LBNF2SquerylXForm[Trgt,Ctxt[N,C,L,T]] {
  def context( grammar : LGrammar ) : Ctxt[NTerminal,Cat,Label,Trgt]
  def compileGrammar( grammar : LGrammar ) : Trgt

  def compileDef(
    defn : LDef, ctxt : Ctxt[NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileRule(
    rule : Def , ctxt : Ctxt[NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileLabel(
    rule  : Rule , ctxt : Ctxt[NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileItem(
    item : Item, ctxt : Ctxt[NTerminal,Cat,Label,Trgt]
  ) : Trgt
}

trait SimpleLogging {
  def logStream : java.io.PrintWriter
  def log( s : String ) = {
    logStream.println( s )
  }
}

trait NodeIO extends SimpleLogging {
  def out : java.io.PrintWriter
  def myprintAll(nodes: Seq[Node]) {
    for (node <- nodes)
      myprint(node)
  }
  
  def myprint(n: Node): Unit = n match {
    case Text(s)          => out.print(s)
    case EntityRef("lt")  => out.print('<')
    case EntityRef("gt")  => out.print('>')
    case EntityRef("amp") => out.print('&')
    case atom: Atom[_]    => out.print(atom.text)
    case elem: Elem       => myprintAll(elem.child)
    case _                => log(
      "error in xsd:run: encountered " + n.getClass() + " " + n.toString
    )
  }
}

class NYIException( msg : String ) extends Exception( msg )

trait MapCtxt[N,C,L,T] {
  def nonTerminalMap : Map[N,T]
  def categoryMap    : Map[C,T]
  def labelMap       : Map[L,T]
}

class SquerylCtxt[N,C,L,T](
  override val nonTerminalMap : Map[N,T],
  override val categoryMap    : Map[C,T],
  override val labelMap       : Map[L,T]
) extends MapCtxt[N,C,L,T]

object SquerylCtxt {
  def unapply[N,C,L,T]( sqrlCtxt : SquerylCtxt[N,C,L,T] )
  : Option[(Map[N,T],Map[C,T],Map[L,T])] = {
    Some(
      (
	sqrlCtxt.nonTerminalMap,
	sqrlCtxt.categoryMap,
	sqrlCtxt.labelMap
      )
    )
  }
}

class LBNF2SquerylCompiler(
  val packageName : String
) extends LBNF2SquerylXForm[Node,SquerylCtxt]
with UUIDOps {
  import scala.collection.JavaConversions._
  def imports( ) : Node = {
    <source>
    <source>import org.squeryl._</source>
    <source>import org.squeryl.customtypes.CustomTypesMode._</source>
    <source>import org.squeryl.customtypes._</source>
    <source>import org.squeryl.adapters.H2Adapter</source>
    <source>import java.sql.{{SQLException, Connection => SQLConnection}}</source>
    <source>import org.squeryl.dsl._</source>    
    <source>import java.net.URI</source>
    <source>import _root_.java.util.UUID</source>
    <source>import java.sql.DatabaseMetaData</source>
    <source>import java.sql.ResultSet</source>
    </source>
  }
  def packageDecl() : Node = {
    <source>package { packageName }</source>
  }
  
  lazy val _contexts =
    new scala.collection.mutable.HashMap[
      LGrammar,
      SquerylCtxt[NTerminal,Cat,Label,Node]
    ]()

  def context( grammar : LGrammar )
  : SquerylCtxt[NTerminal,Cat,Label,Node] = {
    _contexts.get( grammar ) match {
      case Some( ctxt ) => ctxt
      case None => {
	val ctxt =
	  new SquerylCtxt[NTerminal,Cat,Label,Node](
	    scala.collection.mutable.HashMap[NTerminal,Node](),
	    scala.collection.mutable.HashMap[Cat,Node](),
	    scala.collection.mutable.HashMap[Label,Node]()
	  )
	_contexts( grammar ) = ctxt
	ctxt
      }
    }
  }

  def compileGrammar( grammar : LGrammar ) : Node = {
    grammar match {
      case lgr : LGr => {
	<source>{ packageDecl() }
	{ imports( ) }

	{ for( ldef <- lgr.listldef_ )
	  yield {
	    compileDef( ldef, context( grammar ) )
	  } }
	</source>
      }
    }
  }
  def compileDef(
    defn : LDef,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    defn match {
      case defAll : DefAll => {
	<source>{compileRule( defAll.def_, ctxt )}</source>
      }
      case defSome : DefSome => {
	<source>throw new NYIException( "DefSome" )</source>
      }
      case defView : LDefView => {
	<source>throw new NYIException( "DefSome" )</source>
      }
    }    
  }
  
  // Utility
  def isCollectionRule(
    rule : Rule,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Boolean = {
    rule.label_ match {
      case labNoP : LabNoP => {
	labNoP.labeleyed_ match {
	  case id : EyeD => false
	  case _ => true
	}
      }
      case labP : LabP => {
	labP.labeleyed_ match {
	  case id : EyeD => false
	  case _ => true
	}
      }
      case labF : LabF => {
	// labNoP.labeleyed_1 match {
// 	  case id : EyeD => false
// 	  case _ => true
// 	}
	true
      }
      case labPF : LabPF => {
	// labNoP.labeleyed_1 match {
// 	  case id : EyeD => false
// 	  case _ => true
// 	}
	true
      }
    }
  }

  def classNameFromNode( n : Node ) : String = {
    val nt = n.text
    nt.substring( 0, nt.indexOf( "(" ) ).replace( "class ", "" )
  }

  def atomNTClassName(
    label : Label,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : String = {
    ctxt.labelMap.get( label ) match {
      case Some( n ) => {
	classNameFromNode( n )
      }
      case None => {
	label match {
	  case labNoP : LabNoP => {
	    val lblId = labNoP.labeleyed_
	    lblId match {
	      case id : EyeD => id.ident_
	    }
	  }	  
	  case labP : LabP => {
	    val lblId = labP.labeleyed_
	    lblId match {
	      case id : EyeD => id.ident_
	    }
	  }
	}
      }
    }    
  }

  def atomTraitName(
    cat : Cat, 
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    <source>Do me!</source>
  }

  def extractTypes(
    fmls : Node
  ) : Node = {
    <source>Do me!</source>
  }

  def extractAccesses(
    inst : String,
    fmls : Node
  ) : Node = {
    <source>Do me!</source>
  }

  def compileRule(
    rdef : Def ,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    rdef match {
      case rule : Rule => {
	if ( isCollectionRule( rule, ctxt ) ) {
	  // Do it!
	  <source>throw NYIException( "collection rule" )</source>
	}
	else {	  
	  val lblTrgt =
	    ctxt.labelMap.get( rule.label_  ) match {
	      // we've seen this one before
	      case Some( n ) => n
	      // first time
	      case None => {
		val className = atomNTClassName( rule.label_, ctxt )
		val varName = getUUID().toString
		val members = compileItemList( rule.listitem_, ctxt )  
		val catTrgt =
		  <source>
		  {
		    ctxt.categoryMap.get( rule.cat_ ) match {
		      case Some( n ) => {<source/>}
		      case None => {
			val catTrgt =
			  <source>
			  trait {atomTraitName( rule.cat_, ctxt ).text}
		      
			  </source>
			ctxt.categoryMap( rule.cat_ ) = catTrgt
		      }
		    }
		  }
		</source>
		val trgt =
		  <source>		  
		  {catTrgt.text}
		  class {className}(
		    {members._1.text}
		  ) extends {atomTraitName( rule.cat_, ctxt ).text} {{
		    {members._2.text}
		  }}
		
		  object {className} {{
		    def unapply( {varName} : {className} )
		    : Option[({extractTypes( members._1 ).text})] = {
		      Some( ({extractAccesses( varName, members._1 ).text}) ) 
		    }
		  }}
		  </source>
		ctxt.labelMap( rule.label_ ) = trgt
		trgt
	      }	    
	    }
	  lblTrgt
	}
      }
    }
  }

  def compileLabel(
    rule : Rule,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    val className = atomNTClassName( rule.label_, ctxt )
    val varName = getUUID().toString
    val members = compileItemList( rule.listitem_, ctxt )
    val trgt =
      <source>
    class {className}(
      {members._1.text}
    ) extends {atomTraitName( rule.cat_, ctxt ).text}
    
    object {className} {{
      def unapply( {varName} : {className} )
      : Option[({extractTypes( members._1 ).text})] = {
	Some( ({extractAccesses( varName, members._1 ).text}) ) 
      }
    }}
    </source>
    ctxt.labelMap( rule.label_ ) = trgt
    trgt
  }
  
  def compileCategory(
    rule : Rule,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    ctxt.categoryMap.get( rule.cat_ ) match {
      case Some( n ) => n
      case None => {
	val catTrgt =
	  <source>
	  trait {atomTraitName( rule.cat_, ctxt ).text}
	  </source>
	ctxt.categoryMap( rule.cat_ ) = catTrgt
	catTrgt
      }
    }
  }

  def compileItemList( 
    items : ListItem,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : (Node,Node) = {
    val (atoms,molecules) =
      items.partition(
	{
	  ( item ) => {
	    item match {
	      case nterm : NTerminal => {		
		nterm.cat_ match {
		  case _ : EyeDCat => true
		  case _ : ListCat => false
		}
	      }
	      case term : Terminal => true
	    }
	  }
	}
      )
    val atomRefs =
      for( item <- atoms if item.isInstanceOf[NTerminal] )
      yield {
	item match {
	  case nterm : NTerminal => {
	    val varName = getUUID().toString
	    varName + ":" + (ctxt.nonTerminalMap.get( nterm ) match {
	      case Some( n ) => {
		n.text
	      }
	      case None => {
		val ntNode =
		  <source>
		  Key {"/* " + atomTraitName( nterm.cat_, ctxt ) + " */"}
	          </source>
		ctxt.nonTerminalMap( nterm ) = ntNode
		ntNode.text
	      }
	    })
	  }
	}
      }
    val moleRefs =
      for( item <- molecules )
      yield {
	"Do me!"
      }

    ( <source>{atomRefs}</source>, <source>{moleRefs}</source> )
  }

  def compileItem(
    item : Item,
    ctxt : SquerylCtxt[NTerminal,Cat,Label,Node]
  ) : Node = {
    <source/>
  }
}
