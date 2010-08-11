// -*- mode: Scala;-*- 
// Filename:    SchemaCleaner.scala 
// Authors:     lgm                                                    
// Creation:    Thu Aug  5 18:19:18 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

package com.biosimilarity.lift.lib

trait SchemaCleaner {
  def groundTypeNames : List[String]

  def loadSchema( fileName : String ) = {
    scala.xml.XML.loadFile( fileName )
  }

  def cleanNodes(
    loadNode : scala.xml.Elem,
    groundTypeNames : List[String]
  ) = {    
    ((for( es <- (loadNode \ "complexType") )
    yield {
      es
    })
    ++
    (for( es <- (loadNode \ "element");
	 tag = (es \ "@name").head.asInstanceOf[scala.xml.Text].data )
     yield {
       if ( !groundTypeNames.contains( tag ) ) {
	 es
       }
       else {
	 tag match {
	   case "Integer" => {
  	     <xs:element name="Integer">
	       <xs:complexType>
	          <xs:attribute name="value"
	                        type="xs:integer"
	                        use="required"/>
	       </xs:complexType>
	     </xs:element>
	   }
	   case "Double" => {
	     <xs:element name="Double">
	        <xs:complexType>
	           <xs:attribute name="value"
	                         type="xs:double"
	                         use="required"/>
	        </xs:complexType>
	     </xs:element>
	   }
	   case "String" => {
	     <xs:element name="String">
	        <xs:complexType>
	           <xs:attribute name="value"
	                         type="xs:integer"
	                         use="required"/>
	        </xs:complexType>
	     </xs:element>
	   }
	   case "Ident" => {
	     <xs:element name="Ident">
	        <xs:complexType>
	           <xs:attribute name="value"
		                 type="xs:string"
	                         use="required"/>
	        </xs:complexType>
	     </xs:element>
	   }
	 }
       }
     }))
  }

  def cleanSchemaElement(
    loadNode : scala.xml.Elem,
    groundTypeNames : List[String]
  ) = {
    <xs:schema elementFormDefault="qualified"
               xmlns:xs="http://www.w3.org/2001/XMLSchema">
       { cleanNodes( loadNode, groundTypeNames ) }
    </xs:schema>
  }

  def cleanSchemaFile(
    srcFileName  : String,
    trgtFileName : String
  ) = {
    scala.xml.XML.saveFull(
      trgtFileName,
      cleanSchemaElement(
	loadSchema( srcFileName ),
	groundTypeNames
      ),
      "UTF-8",
      true,
      null
    )
  }
}

object theSchemaCleaner extends SchemaCleaner {
  override val groundTypeNames =
    List( "Integer", "Double", "String", "Ident" )
}
