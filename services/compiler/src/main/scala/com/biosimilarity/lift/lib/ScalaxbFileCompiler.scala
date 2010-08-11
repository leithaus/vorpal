// -*- mode: Scala;-*- 
// Filename:    ScalaxbFileCompiler.scala 
// Authors:     lgm                                                    
// Creation:    Tue Aug  3 17:15:24 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.lib

import _root_.net.liftweb._
import http._
import mapper._
import S._
import SHtml._

import common._
import util._
import Helpers._

import _root_.scala.xml.{NodeSeq, Text, Group}
import _root_.java.util.Locale

import java.io.{StringWriter}
import scala.collection.{Map, Set}
import scala.collection.mutable.{ListBuffer, ListMap}
import java.io.{File, BufferedReader, Reader, FileReader, Writer, FileWriter}

trait ScalaxbFileCompiler {
  def inToOutMap( v : FileParamHolder ) = {
    Some(( new java.io.InputStreamReader( v.fileStream )
	  -> new StringWriter() )).toMap
  }
  def defaultPackageName = {
    "com.biosimilarity.vorpal"
  }
  def packageNames = {
    val packageNames = ListMap.empty[String, Option[String]]
    packageNames( null ) = Some( defaultPackageName )
    packageNames
  }
  def processReaders( ioMap : Map[Reader,Writer] ) = {
    val m = org.scalaxb.compiler.xsd.Driver
    m.processReaders( ioMap, packageNames )
    ioMap
  }
  def scalaFile( v : FileParamHolder ) = {
    processReaders( inToOutMap( v ).asInstanceOf[Map[Reader,Writer]] ).map( 
      { 
	ab => ab match {
	  case ( a, b ) => {
	    b.toString
	  }
	}
      }
    ).head
  }
}
