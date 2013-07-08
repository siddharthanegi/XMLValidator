package com.xor.validate;

import java.io.File;

import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

public class XmlValidation {

	/**
	 * @param args
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StreamSource xmlSource=new StreamSource(new File("testxml.xml"));
		StreamSource schemaSource=new StreamSource(new File("testSchema.xsd"));
		ValidatingClass checkValid=new ValidatingClass();
		System.out.println(checkValid.validate(xmlSource, schemaSource));
		
	}

}
