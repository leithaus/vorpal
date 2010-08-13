// -*- mode: Scala;-*- 
// Filename:    SquerylSupport.scala 
// Authors:     lgm                                                    
// Creation:    Thu Aug 12 16:10:27 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.model.SquerylSupport
import com.biosimilarity.lift.lib.UUIDOps

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

trait Domain[A] {
  self: Product1[Any] =>

  def label             : String
  def baseURI           : URI
  def asURI             : URI
  def validate( a : A ) : Unit
  def value             : A

  validate( value )
}

trait EmminentDomain[A] extends Domain[A] {
  self: Product1[Any] =>
    var _baseURI        : Option[URI] = None 
    var _uri            : Option[URI] = None

    def baseURI = {
      _baseURI match {
        case Some( uri ) => uri
        case None => {
          val uri = new URI( "agent", "domain", "" )
          _baseURI = Some( uri )
          uri
        }
      }
    }
    def asURI = {
      _uri match {
        case Some( uri ) => uri
        case None => {
          val uri =
            baseURI.relativize(
              new URI(
                "agent",
                "www.biosimilarity.com",
                "domain",
                label + "=" + value,
                ""
              )
            )
          _uri = Some( uri )
          uri
        }
      }      
    }  
}

/* -------------------------------------------------------------------------- */
/* Persistent properties                                                      */
/* -------------------------------------------------------------------------- */

class Name( val name : String )
extends StringField( name )
with EmminentDomain[String] {
  def excludedChars : List[String] = List( " " )
  def label = "Name"
  def validate( a : String ) = {
    for( c <- excludedChars ) {
      if ( a.contains( c ) ) {
        throw new Exception( "names are not allowed to contain: " + c )
      }
    }
  }
}

abstract class Reference( val key : Long )
extends LongField( key )
with EmminentDomain[Long] {
  def labelQualifier : Option[String]
  def label = {
    (
      (
        labelQualifier match {
          case Some( lblQlfr ) => lblQlfr
          case None => ""
        }
      )
      + "Id"
    )
  }
  def validate( a : Long ) = {
    if ( a < 0 ) {
      throw new Exception( "keys must be positive: " + key )
    }
  }
}

class Key( val id : Long ) extends Reference( id ) {
  var _labelQualifierMemo : Option[String] = None
  def labelQualifier = _labelQualifierMemo
  def labelQualifier( lblQlfr : String ) = {
    _labelQualifierMemo = Some( lblQlfr )
  }
}

//class Identity( val uuid : getUUID() )
//extends StringField( uuid.toString )
class Identity( override val value : String )
extends StringField( value )
with EmminentDomain[String] 
with UUIDOps {
  def asUUID : UUID = {
    getUUID( value )
  }
  def asNumeric : BigInt = {
    (( value.toString.split( "-" ) :\ ( BigInt( "0", 16 ), 0 ) )(
      { ( s : String, acc : ( BigInt, Int ) ) => {
        val sBI = BigInt( s, 16 )
        acc match {
          case ( total, shift ) =>
            ((( sBI * BigInt( 16 ).pow( shift ) ) + total), (s.length + shift))
        }
      }
     }
    ))._1
  }
  def asID : Long = {
    (asNumeric % java.lang.Integer.MAX_VALUE).toLong
  }
  def label = "Identity"
  def validate( a : String ) = {
    try {
      if ( a != null ) {
      	getUUID( a )
      }
      else {
      	println( "Warning : null UUID String." )
      }
    }
    catch {
      case e => println( "Warning : " + a + " is not a valid UUID String." )
    }
  }
}

class PURI( val uriStr : String )
extends StringField( uriStr )
with EmminentDomain[String] {  
  def uri : URI = {
    new URI( uriStr )
  }
  def label = "URI"
  def validate( a : String ) = {
    uri.toString.equals( a )
  }
  def email = uriStr.substring(7)
}
