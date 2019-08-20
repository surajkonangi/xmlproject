package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.HashSet;
	import java.util.Set;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class filter {
		static int filtering(NodeList nodelist) {
			int size;
			Set<String> list = new HashSet<String>();
			for (int initial = 2; initial < nodelist.getLength(); initial++) {
				// Get element
				Element element = (Element) nodelist.item(initial);
				String n = element.getNodeName();
				list.add(n);
			}
			size = list.size();

			return size;
		}

		static int Empty(File file) throws ParserConfigurationException, SAXException, IOException {
			int count = 0;
			FileInputStream fileInputStream = new FileInputStream(file);
			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.parse(fileInputStream);
			Element employe = document.getDocumentElement();

			NodeList nodelist = document.getElementsByTagName("*");

			for (int initial = 2; initial < nodelist.getLength(); initial++) {

				Element element = (Element) nodelist.item(initial);
				String str = employe.getElementsByTagName(element.getNodeName()).item(0).getTextContent();
				if (str == "") {
					count++;
				}
			}
			return count;
		}

}
