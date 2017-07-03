package com.weijiajiao.utils;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParserTest {
	private static ClassPathResource resource;
	private static DOMParser parser ;
	@BeforeClass
	public static void  init() throws IOException {
		resource = new ClassPathResource("test.xml");
		parser = new DOMParser();
		parser.parse(resource.getInputStream());
	}
	
//	@Test
	public void testPrintContent() throws IOException {
		parser.printContent();
	}
	
	
	@Test
	public void testByTagName() throws IOException {
		NodeList list = parser.getElementsByTagName("nonce_str");
		Node node = list.item(0);
		Assert.assertEquals("not equal", "1add1a30ac87aa2db72f57a2375d8fec", node.getTextContent());
	}

	@Test
	public void testMakeDom() throws IOException, ParserConfigurationException {
		DOMParser.printContent(parser.makeDocument());;
	}
}
