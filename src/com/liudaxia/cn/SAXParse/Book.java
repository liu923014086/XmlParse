package com.liudaxia.cn.SAXParse;
/**
 * <book id="1">
		        <name>冰与火之歌</name>
		        <author>乔治马丁</author>
		        <year>2014</year>
		        <price>89</price>
		    </book>
 * @author Administrator
 *
 */
public class Book {

	private String id;
	private String name;
	private String author;
	private String year;
	private String price;
	private String language;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
