package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;
	import javax.xml.xpath.XPathExpressionException;

	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Inserter extends SubElements {
		static String username;
		int number, idvalue;
		static Scanner sc = new Scanner(System.in);

		void insertion(File file) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,
				TransformerException {
			int n = filter.Empty(file);
			if (n > 1) {
				First first1 = new First();
				file = first1.firstinsert(file);
			} else {
				FileInputStream fileInputStream = new FileInputStream(file);
				DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
				Document document = documentbuild.parse(fileInputStream);
				document.getDocumentElement().normalize();
				Element Employe = document.getDocumentElement();
				number = getlimit();
				int count = 1;
				for (int initial = 0; initial < number; initial++) {
					System.out.println("Enter the details of Element:" + count);
					Element example = (Element) Employe.getChildNodes().item(0);
					Element subEle = document.createElement(example.getTagName());
					Employe.appendChild(subEle);
					Attr attribute = document.createAttribute("id");
					idvalue = getEmp_id();
					attribute.setValue(Integer.toString(idvalue));
					subEle.setAttributeNode(attribute);
					NodeList nodelist = document.getElementsByTagName("*");
					document = com.xml.SubElements.SubElements(nodelist, document, subEle);
					DOMSource source = new DOMSource(document);

					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer = transformerFactory.newTransformer();
					StreamResult result = new StreamResult(file);
					transformer.transform(source, result);
					count++;
					System.out.println("Successfully Inserted");
				}

			}
		}


}
