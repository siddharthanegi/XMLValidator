package com.xor.validate;

import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXParseException;

public class ValidatingClass{

	private static SchemaFactory schemaFactory;
	
	public ValidatingClass(){
		ValidatingClass.schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	}
	
	public synchronized boolean validate(StreamSource xmlSource,StreamSource schemaSource) throws Exception{
		
		Schema schema=schemaFactory.newSchema(schemaSource);
		Validator validator=schema.newValidator();
		// final List<SAXParseException> exceptions = new LinkedList<SAXParseException>();
		  CustomErrorHandler customErrorHandler=new CustomErrorHandler();
		 validator.setErrorHandler(customErrorHandler);
		 validator.validate(xmlSource);
		 List<SAXParseException> exceptions=customErrorHandler.getExceptions();
			if(exceptions.isEmpty()){
				return true;
			}
			else{
				Iterator<SAXParseException> it=exceptions.iterator();
				while(it.hasNext()){
					System.out.println(it.next().getMessage());
				}
		return false;
			}
	}
	
	public static void setSchemaFactory() {
		ValidatingClass.schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	}
	

}
