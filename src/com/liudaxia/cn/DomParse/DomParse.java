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
 * 采用基础的dom解析xml的方式
 * @author Administrator
 *
 */
public class DomParse {
	/**
	 * <?xml version="1.0" encoding="UTF-8"?>
		<bookstore>
		    <book id="1">
		        <name>冰与火之歌</name>
		        <author>乔治马丁</author>
		        <year>2014</year>
		        <price>89</price>
		    </book>
		    <book id="2">
		        <name>安徒生童话</name>
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
		System.out.println("一个有"+elementsByTagName.getLength()+"本书");
		for(int i=0;i<elementsByTagName.getLength();i++){
			System.out.println("下面开始遍历第"+(i+1)+"本书");
			Node item = elementsByTagName.item(i);
			System.out.println("第"+(i+1)+"本书的nodename:"+item.getNodeName());
			NamedNodeMap attributes = item.getAttributes();
			for(int j=0;j<attributes.getLength();j++){
				Node node = attributes.item(j);
				System.out.println(node.getNodeName()+"="+node.getNodeValue());
			}
			
			
			//开始遍历孩子节点
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












