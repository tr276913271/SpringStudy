package me.kagemi.mybatisread.test;

import java.lang.reflect.Constructor;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.parsing.GenericTokenParser;
import org.apache.ibatis.parsing.TokenHandler;
import org.junit.Ignore;
import org.junit.Test;

import me.kagami.mybatisread.Books;

public class AppTest {
	@Ignore
	@Test
	public void classloaderTest() {
		ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println(systemClassLoader);
	}
	@Ignore
	@Test
	public void genericTokenParserTest() {
		GenericTokenParser parser = new GenericTokenParser("${", "}", new TokenHandler() {
			public String handleToken(String content) {
				return "***";
			}
		});
		
		System.out.println(parser.parse("abc\\${asdf}abv${aa}"));
	}
	
	@Test
	public void reflectorTest() {
		 Constructor<?>[] consts = Books.class.getDeclaredConstructors();
		 for (Constructor<?> constructor : consts) {
//			System.out.println(constructor.getParameters().length);
		}
	}

}
