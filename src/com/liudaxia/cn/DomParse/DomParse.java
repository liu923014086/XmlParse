package com.liudaxia.cn.DomParse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ���û�����dom����xml�ķ�ʽ
 * @author Administrator
 *
 */
public class DomParse {
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
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder newDocumentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = newDocumentBuilder.parse("book.xml");
		NodeList elementsByTagName = document.getElementsByTagName("book");
		System.out.println("һ����"+elementsByTagName.getLength()+"����");
		for(int i=0;i<elementsByTagName.getLength();i++){
			System.out.println("���濪ʼ������"+(i+1)+"����");
			Node item = elementsByTagName.item(i);
			System.out.println("��"+(i+1)+"�����nodename:"+item.getNodeName());
			NamedNodeMap attributes = item.getAttributes();
			for(int j=0;j<attributes.getLength();j++){
				Node node = attributes.item(j);
				System.out.println(node.getNodeName()+"="+node.getNodeValue());
			}
			
			
			//��ʼ�������ӽڵ�
			NodeList childNodes = item.getChildNodes();
			for(int k=0;k<childNodes.getLength();k++){
				Node item2 = childNodes.item(k);
				if(item2.getNodeType()==Node.ELEMENT_NODE){
					
					System.out.println(item2.getNodeName()+"---------"+item2.getTextContent());
				}
			}
		}
	}

}












