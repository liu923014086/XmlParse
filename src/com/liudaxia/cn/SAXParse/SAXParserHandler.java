package com.liudaxia.cn.SAXParse;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserHandler extends DefaultHandler {
	
	String value = null;
    Book book = null;
    private ArrayList<Book> bookList = new ArrayList<Book>();
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    int bookIndex = 0;

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		 if (qName.equals("book")) {
	            bookIndex++;
	            //����һ��book����
	            book = new Book();
	            //��ʼ����bookԪ�ص�����
	            System.out.println("======================��ʼ����ĳһ���������=================");
	            //��֪��bookԪ�������Ե������Լ���������λ�ȡ�������Լ�����ֵ
	            int num = attributes.getLength();
	            for(int i = 0; i < num; i++){
	                System.out.print("bookԪ�صĵ�" + (i + 1) +  "���������ǣ�"
	                        + attributes.getQName(i));
	                System.out.println("---����ֵ�ǣ�" + attributes.getValue(i));
	                if (attributes.getQName(i).equals("id")) {
	                    book.setId(attributes.getValue(i));
	                }
	            }
	        }
	        else if (!qName.equals("name") && !qName.equals("bookstore")) {
	            System.out.print("�ڵ����ǣ�" + qName + "---");
	        }
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		
		 //�ж��Ƿ����һ�����Ѿ���������
        if (qName.equals("book")) {
            bookList.add(book);
            book = null;
            System.out.println("======================��������ĳһ���������=================");
        }
        else if (qName.equals("name")) {
            book.setName(value);
        }
        else if (qName.equals("author")) {
            book.setAuthor(value);
        }
        else if (qName.equals("year")) {
            book.setYear(value);
        }
        else if (qName.equals("price")) {
            book.setPrice(value);
        }
        else if (qName.equals("language")) {
            book.setLanguage(value);
        }
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		 value = new String(ch, start, length);
	        if (!value.trim().equals("")) {
	            System.out.println("�ڵ�ֵ�ǣ�" + value);
	        }
	}

}