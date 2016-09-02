package me.kagemi.mybatisread.test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathTest {
	@Before
	public void before() {
		System.out.println("===========================================================");
	}
	/**
	 * 总的来说，xpath好用一点 
	 */
	@Test
	public void dom4jTest() throws Exception {
		org.dom4j.Document document = null;
		SAXReader saxReader = new SAXReader();
		document = saxReader.read(new File("bookstore.xml")); // 读取XML文件,获得document对象
		Element root = document.getRootElement();//dom4j 自带
		for (Iterator i = root.elementIterator("book"); i.hasNext();) {
			Element book = (Element) i.next();
			System.out.println(book.getName());
		}
		System.out.println("===========================================================");
		List<Element> books = document.selectNodes("/bookstore/book");//xpath
		for (Element element : books) {
			System.out.println(element.getName());
		}
		
		//以上两种方法是一样的
		
		List<Attribute> attributes = document.selectNodes("/bookstore/book/@category");
		for (Attribute attribute : attributes) {
			System.out.println(attribute.getValue());
		}
	}
	@Ignore
	@Test
	public void xpathTest() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		DocumentBuilderFactory domfactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = domfactory.newDocumentBuilder();

		XPathFactory xpfactory = XPathFactory.newInstance();
		XPath xpath = xpfactory.newXPath();
		Document document = builder.parse(new File("bookstore.xml"));
		// 获取节点值
		// @ 选取属性
		String webTitle = (String) xpath.evaluate("/bookstore/book[@category='WEB']/title/text()", document, XPathConstants.STRING);
		System.out.println(webTitle);

		// 获取节点属性值
		String webTitleLang = (String) xpath.evaluate("/bookstore/book[@category='WEB']/title/@lang", document, XPathConstants.STRING);
		System.out.println(webTitleLang);
		// 获取节点对象
		Node bookWeb = (Node) xpath.evaluate("/bookstore/book[@category='WEB']", document, XPathConstants.NODE);
		System.out.println(bookWeb.getNodeName());
		// 获取节点集合
		NodeList books = (NodeList) xpath.evaluate("/bookstore/book", document, XPathConstants.NODESET);
		for (int i = 0; i < books.getLength(); i++) {
			Node book = books.item(i);
			System.out.println(xpath.evaluate("@category", book, XPathConstants.STRING));
		}
	}
}
