// -*- mode: Scala;-*- 
// Filename:    BNF2Squeryl.scala 
// Authors:     lgm                                                    
// Creation:    Wed Aug 11 22:54:47 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.model

import com.biosimilarity.lift.lib.UUIDOps
import com.biosimilarity.lift.lib.{Verbosity,Terse,Informative,Blogger}
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

trait LBNF2SquerylXForm[Trgt,Ctxt[G,N,C,L,T]] {
  def context( grammar : LGrammar )
  : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  def resetContext( grammar : LGrammar ) : Unit
  def compileGrammar( grammar : LGrammar ) : Trgt

  def compileDef(
    defn : LDef,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileRule(
    rule : Def ,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileLabel(
    rule : Rule ,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : Trgt
  def compileItemList( 
    rule : Rule,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : ( Trgt, Trgt )
  def compileItem(
    item : Item,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : Trgt

  def schema(
    grammar : LGrammar,
    ctxt : Ctxt[LGrammar,NTerminal,Cat,Label,Trgt]
  ) : Trgt 
}

trait SimpleUtilities {
  def splitFmlsFromTypes(
    fmlsNode : Node
  ) : ( List[String], List[String] ) = {
    splitFmlsFromTypes( fmlsNode.text )    
  }

  def splitFmlsFromTypes(
    fmlsTxt : String
  ) : ( List[String], List[String] ) = {    
    fmlsTxt match {
      case "" => { ( List(), List() ) }
      case _ => {
	val fmlsPairs =
	  for( fmlPair <- fmlsTxt.split( "," ) )
	  yield {
	    val a = fmlPair.split( ":" )
	    ( a( 0 ).replace( " ", "" ), a( 1 ).replace( " ", "" ) )
	  }
	val ( fmls, fmlTyps ) = fmlsPairs.unzip
	( fmls.toList, fmlTyps.toList )
      }
    }
  }
  
  def commaSeparateStrings( addNL : Boolean )( ls : List[String] )
  : String = {
    ls match {
      case t :: ts => {
	( t /: ts )(
	  { ( acc, e ) =>
	    acc + " ," + (if (addNL) "\n" else " ") + e
	 } )
      }
      case _ => ""
    }
  }
}

class NYIException( msg : String ) extends Exception( msg )

trait MapCtxt[G,N,C,L,T] {
  def nonTerminalMap : Map[N,T]
  def categoryMap    : Map[C,T]
  def labelMap       : Map[L,T]
}

class SquerylCtxt[G,N,C,L,T](
  override val nonTerminalMap  : Map[N,T],
  override val categoryMap     : Map[C,T],
  override val labelMap        : Map[L,T],
           val relationDeclMap : Map[G,T],
           var schema          : Option[T], // ouch!
           val focus           : G
) extends MapCtxt[G,N,C,L,T] {
  //def trgt() : Option[T]
}

object SquerylCtxt {
  def unapply[G,N,C,L,T]( sqrlCtxt : SquerylCtxt[G,N,C,L,T] )
  : Option[(Map[N,T],Map[C,T],Map[L,T],Map[G,T],Option[T],G)] = {
    Some(
      (
	sqrlCtxt.nonTerminalMap,
	sqrlCtxt.categoryMap,
	sqrlCtxt.labelMap,
	sqrlCtxt.relationDeclMap,
	sqrlCtxt.schema,
	sqrlCtxt.focus
      )
    )
  }
}

class LBNF2SquerylCompiler(
  val packageName : String,
  override val verbosity : Verbosity
) extends LBNF2SquerylXForm[Node,SquerylCtxt]
with UUIDOps
with SimpleUtilities
with SimpleLogging {
  import scala.collection.JavaConversions._
  def log : java.io.PrintWriter = {
    new java.io.PrintWriter( System.out )
  }
  def imports( ) : Node = {
    <source>
import com.biosimilarity.lift.model.SquerylSupport
import org.squeryl._
import org.squeryl.customtypes.CustomTypesMode._
import org.squeryl.customtypes._
import org.squeryl.adapters.H2Adapter    
import org.squeryl.dsl._
import java.sql.{{SQLException, Connection => SQLConnection}}
import java.sql.DatabaseMetaData
import java.sql.ResultSet
import java.net.URI
import java.util.UUID
    </source>
  }
  def packageDecl() : Node = {
    <source>package { packageName }</source>
  }
  
  lazy val _contexts =
    new scala.collection.mutable.HashMap[
      LGrammar,
      SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
    ]()

  def context( grammar : LGrammar )
  : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node] = {
    _contexts.get( grammar ) match {
      case Some( ctxt ) => ctxt
      case None => {
	val ctxt =
	  new SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node](
	    scala.collection.mutable.HashMap[NTerminal,Node](),
	    scala.collection.mutable.HashMap[Cat,Node](),
	    scala.collection.mutable.HashMap[Label,Node](),
	    scala.collection.mutable.HashMap[LGrammar,Node](),
	    None,
	    grammar
	  )
	_contexts( grammar ) = ctxt
	ctxt
      }
    }
  }

  def resetContext( grammar : LGrammar ) : Unit = {      
    _contexts( grammar ) =
      new SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node](
	scala.collection.mutable.HashMap[NTerminal,Node](),
	scala.collection.mutable.HashMap[Cat,Node](),
	scala.collection.mutable.HashMap[Label,Node](),
	scala.collection.mutable.HashMap[LGrammar,Node](),
	None,
	grammar
      )
  }

  def compileGrammar( grammar : LGrammar ) : Node = {
    log( "compiling LGrammar" )
    grammar match {
      case lgr : LGr => {
	val ctxt = context( grammar )
	<source>{ packageDecl().text }
	{ imports( ).text }
	{ for( ldef <- lgr.listldef_ )
	  yield {
	    compileDef( ldef, ctxt ).text
	  } }
	{val scm = schema( grammar, ctxt )
	 val scmText = scm.text
	 (scmText.substring( 0, scmText.lastIndexOf( "}" ) )
	  + "\n"
	  + (ctxt.relationDeclMap.get( grammar ) match {
	  case Some( rds ) => rds.text
	  case None => ""
	}) + "\n" + "}" ) }
	</source>
      }
    }
  }
  def compileDef(
    defn : LDef,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    log( "compiling LDef" )
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
  
  def isCollectionRule(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Option[String] = {
    rule.label_ match {
      //case listCons : ListCons => Some( "(:)" )
      //case listE : ListE => Some( "()" )
      //case listOne : ListOne => Some( "(_)" )

      case labNoP : LabNoP => {
	labNoP.labeleyed_ match {
	  case listCons : ListCons => Some( "(:)" )
	  case listE : ListE => Some( "()" )
	  case listOne : ListOne => Some( "(_)" )
	  case _ => None
	}
      }
      case labP : LabP => {
	labP.labeleyed_ match {
	  case listCons : ListCons => Some( "(:)" )
	  case listE : ListE => Some( "()" )
	  case listOne : ListOne => Some( "(_)" )
	  case _ => None
	}
      }

      case _ => None
    }
  }

  def isCoercionRule(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Option[String] = {
    rule.label_ match {
      //case listCons : ListCons => Some( "(:)" )
      //case listE : ListE => Some( "()" )
      //case listOne : ListOne => Some( "(_)" )

      case labNoP : LabNoP => {
	labNoP.labeleyed_ match {
	  case wild : Wild => Some( "_" )
	  case _ => None
	}
      }
      case labP : LabP => {
	labP.labeleyed_ match {
	  case wild : Wild => Some( "_" )
	  case _ => None
	}
      }

      case _ => None
    }
  }

  def classNameFromNode( n : Node ) : String = {
    val nt = n.text
    nt.substring( 0, nt.indexOf( "(" ) ).replace( "class ", "" )
  }

  def atomNTClassName(
    label : Label,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    ctxt.labelMap.get( label ) match {
      case Some( n ) => {
	classNameFromNode( n )
      }
      case None => {
	val ident = (label match {
	  case labNoP : LabNoP => {
	    val lblId = labNoP.labeleyed_
	    lblId match {
	      case id : EyeD => id.ident_
	      case lstCons : ListCons => {
		"listCons"
	      }
	      case lstE : ListE => {
		"listEmpty"
	      }
	      case listOne : ListOne => {
		"listOne"
	      }
	      case wild : Wild => {
		"wild"
	      }
	    }
	  }	  
	  case labP : LabP => {
	    val lblId = labP.labeleyed_
	    lblId match {
	      case id : EyeD => id.ident_
	      case lstCons : ListCons => {
		"listCons"
	      }
	      case lstE : ListE => {
		"listEmpty"
	      }
	      case listOne : ListOne => {
		"listOne"
	      }
	      case wild : Wild => {
		"wild"
	      }
	    }
	  }
	})
	  ident.replace( "\n", "" ).replace( "\t", "" ).replace( " ", "" )
      }
    }    
  }

  def atomTraitName(
    rule : Rule,
    cat : Cat, 
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    <source>{
      cat match {
	case idCat : EyeDCat => {
	  val ident = idCat.ident_
	  ident.replace( "\n", "" ).replace( "\t", "" ).replace( " ", "" )
	}
	case listCat : ListCat => {
	  //throw new Exception( "shouldn't get here!" )
	  listCat.cat_ match {
	    case idCat : EyeDCat => {
	      val ident = idCat.ident_
	      "[" + ident.replace( "\n", "" )
		    .replace( "\t", "" )
		    .replace( " ", "" ) + "]"
	    }
	    case _ => {	      
	      throw new Exception( "bailing on nested case" )
	    }
	  }
	}
      }
    }</source>
  }

  def categoryName(
    cat : Cat, 
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    cat match {
      case idCat : EyeDCat => {
	val ident = idCat.ident_
	ident.replace( "\n", "" ).replace( "\t", "" ).replace( " ", "" )
      }
      case listCat : ListCat => {
	//throw new Exception( "shouldn't get here!" )
	listCat.cat_ match {
	  case idCat : EyeDCat => {
	    val ident = idCat.ident_
	    "[" + ident.replace( "\n", "" )
	    .replace( "\t", "" )
	    .replace( " ", "" ) + "]"
	  }
	  case _ => {	      
	    throw new Exception( "bailing on nested case" )
	  }
	}
      }
    }
  }

  def extractTypes(
    fmlsNode : Node
  ) : Node = {
    val ( fmls, fmlTyps ) = splitFmlsFromTypes( fmlsNode )

    <source>{commaSeparateStrings(false)( fmlTyps )}</source>
  }

  def extractAccesses(
    inst     : String,
    fmlsNode : Node
  ) : Node = {
    val ( fmls, fmlTyps ) = splitFmlsFromTypes( fmlsNode )

    <source>{
      commaSeparateStrings(false)( fmls.map( fml => inst + "." + fml ) )
    }</source>
  }

  def generateVarName() : String = {
    "var" + "_" + getUUID().toString
  }

  def compileRule(
    rdef : Def ,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    log( "compiling Def" )
    rdef match {
      case rule : Rule => {
	log( "compiling Rule" )
	isCollectionRule( rule, ctxt ) match {
	  case Some( colLbl ) => {
	    // Do it!
	    val ruleCat =
	      rule.cat_ match {
		case listCat : ListCat => {
		  listCat.cat_
		}
		case _ =>
		  throw new Exception( "collection rule with non-list cat" )
	      }
	    val catId = 
	      ruleCat match {
		case idCat : EyeDCat => idCat.ident_
		case _ =>
		  throw new Exception( "bailing on nested case" )
	      }
	    <source>/* not compiling a collection rule */
</source>
	  }
	  case None => {	  
	    isCoercionRule( rule, ctxt ) match {
	      case Some( coercionLbl ) => {
		<source>/* not compiling coercion rule */
 </source>
	      }
	      case None => {
		val lblTrgt =
		  ctxt.labelMap.get( rule.label_  ) match {
		    // we've seen this one before
		    case Some( n ) => n
		    // first time
		    case None => {
		      val className = atomNTClassName( rule.label_, ctxt )
		      //val varName = generateVarName()
		      val varName = "inst" + "_" + className
		      val (fields,relations) = compileItemList( rule, ctxt )  
		      
		      log( "rule label : " + className )
		      log( "fields : " + fields.text )
		      log( "relations : " + relations.text )
		      
		      val catTrgt =
			<source>
		      {
			ctxt.categoryMap.get( rule.cat_ ) match {
			  case Some( n ) => {<source/>}
			  case None => {
			    val catTrgt =
			      <source>trait {atomTraitName( rule, rule.cat_, ctxt ).text}</source>
			    ctxt.categoryMap( rule.cat_ ) = catTrgt
			  }
			}
		      }
		      </source>
		      val trgt =
			<source>{catTrgt.text + "\n"} class {className}(
{"val id : Key,\n" + fields.text}
) extends KeyedEntity[LongField]
with {atomTraitName( rule, rule.cat_, ctxt ).text} {{
  {relations.text}
}}
		
object {className} {{
  def unapply( {varName} : {className} )
  : Option[({"Key" + " , " + extractTypes( fields ).text + " , "})] = 
{
  Some( ({varName + ".id , " + extractAccesses( varName, fields ).text}) )
}
}}</source>
		      ctxt.labelMap( rule.label_ ) = trgt
		      trgt
		    }	    
		  }
		lblTrgt
	      }
	    }
	  }
	}
      }
      case rules : Rules => {
	<source>/* didn't compile a rules object */</source>
      }
      case coercions : Coercions => {
	<source>/* didn't compile a coercions object */</source>
      }
      case comment : Absyn.Comment => {
	<source>/* not compiling a comment object */
</source>
      }
      case comments : Absyn.Comments => {
	<source>/* not compiling a comments object */
</source>
      }
      case entryp : Entryp => {
	<source>/* didn't compile an entryp object  */</source>
      }
      case fn : Function => {
	<source>/* didn't compile a function object */</source>
      }
      case intern : Internal => {
	<source>/* didn't compile an intern object */</source>
      }
      case layout : Layout => {
	<source>/* didn't compile a layout object */</source>
      }
      case layoutStop : LayoutStop => {
	<source>/* didn't compile a layoutStop object */</source>
      }
      case layoutTop : LayoutTop => {
	<source>/* didn't compile a layoutTop object */</source>
      }
      case posTkn : PosToken => {
	<source>/* didn't compile a PosToken object */</source>
      }
      case separator : Separator => {
	<source>/* didn't compile a Separator object */</source>
      }
      case terminator : Terminator => {
	<source>/* didn't compile a Terminator object */</source>
      }
      case tkn : Token => {
	<source>/* didn't compile a Token object */</source>
      }
    }
  }

  def compileLabel(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    val className = atomNTClassName( rule.label_, ctxt )
    val varName = getUUID().toString
    val members = compileItemList( rule, ctxt )
    val trgt =
      <source>class {className}(
{members._1.text}
) extends {atomTraitName( rule, rule.cat_, ctxt ).text}
    
object {className} {{
  def unapply( {varName} : {className} )
  : Option[({extractTypes( members._1 ).text})] = {
    Some( ({extractAccesses( varName, members._1 ).text}) ) 
  }
}}</source>
    ctxt.labelMap( rule.label_ ) = trgt
    trgt
  }
  
  def compileCategory(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    ctxt.categoryMap.get( rule.cat_ ) match {
      case Some( n ) => n
      case None => {
	val catTrgt =
	  <source>trait {atomTraitName( rule, rule.cat_, ctxt ).text}</source>
	ctxt.categoryMap( rule.cat_ ) = catTrgt
	catTrgt
      }
    }
  }

  def grammarSchemaName(
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    "Schema" + "_" + getUUID().toString
  }

  def relationTargetName(
    item : Item,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    val cat = (item match {
      case nTerm : NTerminal => {
	nTerm.cat_
      }
      case _ => {
	throw new Exception( "shouldn't be here" )
      }
    })

    cat match {
      case idCat : EyeDCat => {
	throw new Exception( "shouldn't be here" )	
      }
      case lstCat : ListCat => {
	lstCat.cat_ match {
	  case idCat : EyeDCat => {
	    idCat.ident_
	  }
	  case _ => {
	    throw new Exception( "bailing on nest list cat case" )
	  }
	}
      }
    }
  }

  def relationSourceName(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    atomNTClassName( rule.label_, ctxt ).toLowerCase
  }

  def relationSourceElementType(
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    atomNTClassName( rule.label_, ctxt )
  }
  
  def relationName(
    rule : Rule,
    item : Item,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {    
    (
      relationSourceName( rule, ctxt )
      + relationTargetName( item, ctxt )
    )
  }

  def compileItemList( 
    rule : Rule,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : (Node,Node) = {
    val items = rule.listitem_
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
    val catVarNameMap : scala.collection.mutable.HashMap[String,Int] =
      new scala.collection.mutable.HashMap[String,Int]()
    val atomRefs =
      for( item <- atoms if item.isInstanceOf[NTerminal] )
      yield {	
	item match {
	  case nterm : NTerminal => {
	    val catName = categoryName( nterm.cat_, ctxt )
	    val catRefCount =
	      catVarNameMap.get( catName ) match {
		case Some( i ) => {
		  val nrefCnt = i + 1
		  catVarNameMap( catName ) = nrefCnt
		  nrefCnt
		}
		case None => {
		  catVarNameMap( catName ) = 1
		  1
		}
	      }
	    val varName = "m" + "_" + catName + "_" + catRefCount
	    varName + " : " + (ctxt.nonTerminalMap.get( nterm ) match {
	      case Some( n ) => {
		n.text
	      }
	      case None => {
		val ntNode =
		  <source>Key {" /* " + atomTraitName( rule, nterm.cat_, ctxt ) + " */"}</source>
		ctxt.nonTerminalMap( nterm ) = ntNode
		ntNode.text
	      }
	    })
	  }
	}
      }

    val moleDecls =
      for( item <- molecules )
      yield {
	val relSrcName = relationSourceName( rule, ctxt )
	val relTrgtName = relationTargetName( item, ctxt ).toLowerCase
	val relSrcElemType = relationSourceElementType( rule, ctxt )
	val schemaName = grammarSchemaName( ctxt ) 
	val relName = relationName( rule, item, ctxt )
	
	val relDecl = 
	  <source>val {relName} = oneToManyRelation( {relSrcName}, {relTrgtName} ).via((o, m) => o.id === m.{relSrcName}Id )</source>
	
	val relInstDecl =
	<source>lazy val {relSrcName} : OneToMany[{relSrcElemType}] =
	    {schemaName}.{relName}.left( this )</source>

	( relDecl, relInstDecl )
      }

    val ( moleRelDecls, moleRelInstDecls ) = moleDecls.unzip
    val currentGrammar = ctxt.focus
    val relationDecls : Node =
      ctxt.relationDeclMap.get( currentGrammar ) match {
	case Some( rds ) => rds
	case None => <relationDecls></relationDecls>
      }
    val nRelDecls = 
      <relationDecls>{ moleRelDecls.toList match {
	case rd :: rds => {
	  ( relationDecls.text /: moleRelDecls )(
	    {
	      ( acc, e ) => {
		acc + "\n" + e.text
	      }
	    }
	  )
	}
	case Nil => {
	  relationDecls.text
	}
      } }</relationDecls>    

    ctxt.relationDeclMap( currentGrammar ) = nRelDecls

    (
      <source>{commaSeparateStrings(true)( atomRefs.toList )}</source>,
      <source>{moleRelInstDecls.map( _.text )}</source>
    )
  }

  def compileItem(
    item : Item,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    <source/>
  }

  def generateTableName(
    label : Label,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    atomNTClassName( label, ctxt ).toLowerCase + "s"
  }

  def generateTableType(
    label : Label,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : String = {
    atomNTClassName( label, ctxt )
  }

  def schema(
    grammar : LGrammar,
    ctxt : SquerylCtxt[LGrammar,NTerminal,Cat,Label,Node]
  ) : Node = {
    ctxt.schema match {
      case Some( n ) => n
      case None => {
	val trgt =
	  <source>object {grammarSchemaName( ctxt )}
    extends Schema with UUIDOps {{	  
      { for( label <- ctxt.labelMap.keys )
	  yield {
	    val tableName = generateTableName( label, ctxt ).replace( "\n", "" ).replace( "\t", "" ).replace( " ", "" )
	    val tableType = generateTableType( label, ctxt ).replace( "\n", "" ).replace( "\t", "" ).replace( " ", "" )
	    <source>val {tableName} = table[{tableType}]( {"\"" + tableName + "\""} )</source>.text + "\n"
	  } }
    }}
	</source>
	ctxt.schema = Some( trgt )
	trgt
      }
    }    
  }
}

trait ParseLBNFStream {
  def in : java.io.InputStream
  def lexer() : Yylex = lexer( in ) 
  def lexer( in : java.io.InputStream ) : Yylex =
    new Yylex( new java.io.InputStreamReader( in ) )
  def parser() : parser = parser( in )
  def parser( in : java.io.InputStream ) : parser =
    new parser( lexer( in ) )
  def parser( lexer : Yylex ) : parser =
    new parser( lexer )
  def parseTree() : LGrammar = parseTree( in )
  def parseTree( in : java.io.InputStream ) : LGrammar =
    (parser( lexer( in ) )).pLGrammar()
  def parseTree( lexer : Yylex ) : LGrammar =
    (parser( lexer )).pLGrammar()
  def parseTree( parser : parser ) : LGrammar = parser.pLGrammar()    
}

trait SimpleLogging {
  def verbosity : Verbosity
  def log : java.io.PrintWriter
  def log( s : String ) : Unit = {
    verbosity match {
      case Terse() => {}
      case _ => {
	log.println( s )
	log.flush
      }
    }
  }
}

trait NodeIO {
  self : SimpleLogging =>
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

class LBNFFile2SquerylCompiler(
  override val packageName    : String,
  override val verbosity      : Verbosity,
  val          inputFileName  : String,
  val          outputFileName : String,
  val          logFileName    : String
) extends LBNF2SquerylCompiler( packageName, verbosity )
with ParseLBNFStream
with NodeIO {
  override lazy val in = new java.io.FileInputStream( inputFileName )
  override lazy val out =
    new java.io.PrintWriter(
      new java.io.FileOutputStream( outputFileName )
    )
  override lazy val log =
    new java.io.PrintWriter(
      new java.io.FileOutputStream( logFileName )
    )

  // apparently the FileInputStream doesn't work well with the parser
  def fileStreamToStringReader = {
    val oStream = new java.io.ByteArrayOutputStream()
    val buf : Array[Byte] = new Array( 1024 )    
    var len : Int = in.read( buf )
    while (len > 0) { oStream.write(buf,0,len); len = in.read(buf) }
    val iStream =
      new java.io.InputStreamReader(
	new java.io.ByteArrayInputStream( oStream.toByteArray )
      )
    val reader = new java.io.BufferedReader( iStream )
    val sb = new StringBuilder()
    var line = reader.readLine
    while (line != null) {
      sb.append( line + "\n" ); line = reader.readLine
    }
    new java.io.StringReader( sb.toString )
  }
  def compileToNode : Node =
    compileGrammar(
      parseTree(
	parser(
	  new Yylex(
	    fileStreamToStringReader
	  )
	)
      )
    )
  def compileToNode( grammar : LGrammar ) : Node = compileGrammar( grammar )
  def compileToFile : Unit = myprint( compileToNode )
}

object UnitTestLBNFFile2SquerylCompiler {
  def testCompiler(
    inputFileName  : String,
    outputFileName : String,
    logFileName    : String
  ) = {
    val lbnfc = new LBNFFile2SquerylCompiler(
      "com.biosimilarity.lbnf",
      Blogger(),
      // "/Users/lgm/work/src/projex/stellar/vorpal/services/compiler/src/main/bnfc/rlambdaDC.cf"
      inputFileName,
      // "/Users/lgm/work/src/projex/stellar/vorpal/services/compiler/tmp/rlambdaDCSqueryl.scala"
      outputFileName,
      // "/Users/lgm/work/src/projex/stellar/vorpal/services/compiler/tmp/rlambdaDCSqueryl.log"
      logFileName
    )
    val reader = lbnfc.fileStreamToStringReader
    val grammar = lbnfc.parseTree( new parser( new Yylex( reader ) ) )
    val ctxt = lbnfc.context( grammar )
    val trgt = lbnfc.compileGrammar( grammar )

    val printer = new java.io.PrintWriter( System.out )

    printer.print( trgt.text )
    
    printer.flush
    
    (grammar, ctxt)
  }
}
