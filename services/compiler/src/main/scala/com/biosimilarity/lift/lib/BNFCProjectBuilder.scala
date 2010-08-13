// -*- mode: Scala;-*- 
// Filename:    BNFCHandler.scala<2> 
// Authors:     lgm                                                    
// Creation:    Sun Aug  8 11:43:17 2010 
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

import com.biosimilarity.lift.model.{
  Valet,VorpalValet,CmdStatus,
  DeliveryStatus,FileNStream,DeliveryFailure
}

import _root_.scala.xml.{NodeSeq, Text, Group}
import _root_.java.util.Locale

import java.io.{StringWriter}
import scala.collection.{Map, Set}
import scala.collection.mutable.{ListBuffer, ListMap}
import scala.util.continuations._ 
import _root_.java.util.UUID
import java.io.{File, BufferedReader, Reader, FileReader, Writer, FileWriter}

trait BNFCProjectBuilder {
  def getProjectName( v : FileParamHolder ) : String = {
    v.fileName.replace( ".cf", "" )
  }
  def acquireValet( projName : String ) = {
    new VorpalValet(
      projName,
      "tmp",
      ".",
      "scala",
      Blogger()
    )
  }
  def createProjectArxiv( cfFileName : String )
  : (java.io.File,java.io.InputStream) = {
    val valet = acquireValet( cfFileName )   
          
    val projID = valet.generateDeliverable(
      new java.io.FileInputStream( cfFileName + ".cf" )
    )

    valet.deliverableStream( projID ) match {
      case FileNStream( f, s ) => {
	( f, s )
      }
      case DeliveryFailure( f ) => {
	throw new Exception( "project arXiv not created" )
      }
    }
  }

  def createProjectArxiv( v : FileParamHolder )
  : (java.io.File,java.io.InputStream) = {
    val valet = acquireValet( getProjectName( v ) )             
    val projID = valet.generateDeliverable( v.fileStream )
    valet.deliverableStream( projID ) match {
      case FileNStream( f, s ) => {
	( f, s )
      }
      case DeliveryFailure( f ) => {
	throw new Exception( "project arXiv not created" )
      }
    }
  }
}
