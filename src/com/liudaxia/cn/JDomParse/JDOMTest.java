package com.liudaxia.cn.JDomParse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.liudaxia.cn.SAXParse.Book;

public class JDOMTest {
    private static ArrayList<Book> booksList = new ArrayList<Book>();
    /**
     * @param args
     */
    public static void main(String[] args) {
        // ���ж�books.xml�ļ���JDOM����
        // ׼������
        // 1.����һ��SAXBuilder�Ķ���
        SAXBuilder saxBuilder = new SAXBuilder();
        InputStream in;
        try {
            // 2.����һ������������xml�ļ����ص���������
            in = new FileInputStream("E:\\project\\XmlParse\\book.xml");
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            // 3.ͨ��saxBuilder��build�����������������ص�saxBuilder��
            Document document = saxBuilder.build(isr);
            // 4.ͨ��document�����ȡxml�ļ��ĸ��ڵ�
            Element rootElement = document.getRootElement();
            // 5.��ȡ���ڵ��µ��ӽڵ��List����
            List<Element> bookList = rootElement.getChildren();
            // �������н���
            for (Element book : bookList) {
                Book bookEntity = new Book();
                System.out.println("======��ʼ������" + (bookList.indexOf(book) + 1)
                        + "��======");
                // ����book�����Լ���
                List<Attribute> attrList = book.getAttributes();
                // //֪���ڵ�����������ʱ����ȡ�ڵ�ֵ
                // book.getAttributeValue("id");
                // ����attrList(��Բ����book�ڵ������Ե����ּ�����)
                for (Attribute attr : attrList) {
                    // ��ȡ������
                    String attrName = attr.getName();
                    // ��ȡ����ֵ
                    String attrValue = attr.getValue();
                    System.out.println("��������" + attrName + "----����ֵ��"
                            + attrValue);
                    if (attrName.equals("id")) {
                        bookEntity.setId(attrValue);
                    }
                }
                // ��book�ڵ���ӽڵ�Ľڵ����Լ��ڵ�ֵ�ı���
                List<Element> bookChilds = book.getChildren();
                for (Element child : bookChilds) {
                    System.out.println("�ڵ�����" + child.getName() + "----�ڵ�ֵ��"
                            + child.getValue());
                    if (child.getName().equals("name")) {
                        bookEntity.setName(child.getValue());
                    }
                    else if (child.getName().equals("author")) {
                        bookEntity.setAuthor(child.getValue());
                    }
                    else if (child.getName().equals("year")) {
                        bookEntity.setYear(child.getValue());
                    }
                    else if (child.getName().equals("price")) {
                        bookEntity.setPrice(child.getValue());
                    }
                    else if (child.getName().equals("language")) {
                        bookEntity.setLanguage(child.getValue());
                    }
                }
                System.out.println("======����������" + (bookList.indexOf(book) + 1)
                        + "��======");
                booksList.add(bookEntity);
                bookEntity = null;
                System.out.println(booksList.size());
                System.out.println(booksList.get(0).getId());
                System.out.println(booksList.get(0).getName());
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

