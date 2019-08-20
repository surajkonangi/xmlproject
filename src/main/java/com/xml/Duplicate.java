package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.xpath.XPathExpressionException;

	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Duplicate {
		static String username;
		static Scanner sc = new Scanner(System.in);

		static Document insertion(File file, int Employee_id) throws ParserConfigurationException, SAXException,
				IOException, XPathExpressionException, TransformerException {
			FileInputStream fileInputStream = new FileInputStream(file);
			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.parse(fileInputStream);
			document.getDocumentElement().normalize();
			Element Employe = document.getDocumentElement();
			Element example = (Element) Employe.getChildNodes().item(0);
			Element subEle = document.createElement(example.getTagName());
			Employe.appendChild(subEle);
			Attr attribute = document.createAttribute("id");
			// System.out.println("Enter the id value");
			attribute.setValue(Integer.toString(Employee_id));
			subEle.setAttributeNode(attribute);
			NodeList nodelist = document.getElementsByTagName("*");
			int size = filter.filtering(nodelist);
			size = size + 1;
			int Elementnumber = 1;
			for (int count2 = 2; count2 < size; count2++) {
				Element element = (Element) nodelist.item(count2);
				System.out.println("Enter the " + Elementnumber + " sub Element value " + element.getNodeName());
				username = sc.next();
				Element childEle1 = document.createElement(element.getNodeName());
				childEle1.appendChild(document.createTextNode(username));
				subEle.appendChild(childEle1);
				Elementnumber++;

			}
			System.out.println("Successfully updated");
			return document;

		}



}
