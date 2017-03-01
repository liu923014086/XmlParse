package com.liudaxia.cn.SAXParse;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParse {
	
	/**
	 * <?xml version="1.0" encoding="UTF-8"?>
		<bookstore>
		    <book id="1">
		        <name>�����֮��</name>
		        <author>������</author>
		        <year>2014</year>
		        <price>89</price>
		    </book>
		    <book id="2">
		        <name>��ͽ��ͯ��</name>
		        <year>2004</year>
		        <price>77</price>
		        <language>English</language>
		    </book>    
		</bookstore>
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		 SAXParserFactory factory = SAXParserFactory.newInstance();
	   
	            SAXParser parser = factory.newSAXParser();
	            SAXParserHandler handler = new SAXParserHandler();
	            parser.parse("book.xml", handler);
	            System.out.println("~��~��~������" + handler.getBookList().size()
	                    + "����");
	            for (Book book : handler.getBookList()) {
	                System.out.println(book.getId());
	                System.out.println(book.getName());
	                System.out.println(book.getAuthor());
	                System.out.println(book.getYear());
	                System.out.println(book.getPrice());
	                System.out.println(book.getLanguage());
	                System.out.println("----finish----");
	            }
	}
}





