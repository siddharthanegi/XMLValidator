package com.xor.validate;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {
	
	private List<SAXParseException> exceptions;

	public CustomErrorHandler() {
		// TODO Auto-generated constructor stub
	this.exceptions=new ArrayList<SAXParseException>();
	}
	public List<SAXParseException> getExceptions() {
		return exceptions;
	}
	

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		exceptions.add(exception);
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		exceptions.add(exception);
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		// TODO Auto-generated method stub
		exceptions.add(exception);
	}

}
