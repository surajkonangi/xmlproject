package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.Transformer;
	import javax.xml.transform.TransformerException;
	import javax.xml.transform.TransformerFactory;
	import javax.xml.transform.dom.DOMSource;
	import javax.xml.transform.stream.StreamResult;

	import org.w3c.dom.Attr;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NamedNodeMap;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class First {
		String username;
		int idvalue = 0;
		Scanner sc = new Scanner(System.in);

		public File firstinsert(File file)
				throws TransformerException, ParserConfigurationException, SAXException, IOException {
			FileInputStream fileInputStream = new FileInputStream(file);

			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.parse(fileInputStream);
			document.getDocumentElement().normalize();
			NodeList nodelist = document.getElementsByTagName("*");
			Element Employe = document.getDocumentElement();
			NodeList examp = Employe.getChildNodes();
			Element example = (Element) examp.item(0);
			NamedNodeMap attr = example.getAttributes();
			Attr attribute = (Attr) attr.getNamedItem("id");
			idvalue = getEmp_id();
			attribute.setValue(Integer.toString(idvalue));

			int size = filter.filtering(nodelist);
			size = 1 + size;
			int Elementnumber = 1;
			for (int count2 = 2; count2 <= size; count2++) {
				Element element = (Element) nodelist.item(count2);
				System.out.println("Enter the " + Elementnumber + " sub Element value " + element.getNodeName());
				username = sc.next();
				Element childEle1 = (Element) example.getElementsByTagName(element.getNodeName()).item(0);
				childEle1.setTextContent(username);
				Elementnumber++;
			}
			DOMSource source = new DOMSource(document);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
			System.out.println("Successfully inserted");
			return file;
		}

		public int getEmp_id() {
			try {
				System.out.println("Enter the id value");
				idvalue = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Id should be integer type correct integer value");
				sc.nextLine();
				getEmp_id();
			}
			return idvalue;
		}
}
