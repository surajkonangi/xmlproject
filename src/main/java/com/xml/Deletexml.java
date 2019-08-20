package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;

	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Deletexml {
		static String username;
		static int idvalue;
		static Scanner sc = new Scanner(System.in);
		static File file = new File("C:\\Users\\Suraj.konangi\\eclipse-workspace\\test\\testng.xml");

		static Document deletevalues()
				throws ParserConfigurationException, SAXException, IOException, TransformerException {
			FileInputStream fileInputStream = new FileInputStream(file);
			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.parse(fileInputStream);
			document.getDocumentElement().normalize();
			Element rootEle = document.getDocumentElement();
			Element esample = (Element) rootEle.getChildNodes().item(0);
			Element subEle = document.createElement(esample.getNodeName());
			rootEle.appendChild(subEle);
			Attr attribute = document.createAttribute("id");
			subEle.setAttributeNode(attribute);
			NodeList nodelist = document.getElementsByTagName("*");
			int size = filter.filtering(nodelist);
			size = 1 + size;
			for (int count = 2; count < size; count++) {
				Element element = (Element) nodelist.item(count);
				Element childEle1 = document.createElement(element.getNodeName());
				subEle.appendChild(childEle1);
			}
			return document;
		}

	}


