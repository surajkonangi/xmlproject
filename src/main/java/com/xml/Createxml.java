package com.xml;
	import java.io.File;
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
	import org.xml.sax.SAXException;

	public class Createxml {
		String id, username;
		int limit = 0, number = 0;;
		Scanner sc = new Scanner(System.in);

		public File createXMl() throws ParserConfigurationException, TransformerException, SAXException, IOException {
			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.newDocument();
			System.out.println("Enter the root Element");
			String root = sc.next();
			Element rootEle = document.createElement(root);
			document.appendChild(rootEle);
			System.out.println("Enter the child Element");
			String sub = sc.next();
			Element subEle = document.createElement(sub);
			rootEle.appendChild(subEle);
			Attr attribute = document.createAttribute("id");
			subEle.setAttributeNode(attribute);
			limit = getlimit();
			int number = 1;
			for (int count = 0; count < limit; count++) {
				System.out.println("Enter the " + number + " sub Element");
				username = sc.next();
				Element childEle1 = document.createElement(username);
				subEle.appendChild(childEle1);
				number++;
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			File file = new File("C:\\Users\\Suraj.konangi\\eclipse-workspace\\test\\testng.xml");
			
			StreamResult streamResult = new StreamResult(file);
			transformer.transform(domSource, streamResult);
			System.out.println("success fully created document");
			System.out.println("Do you want enter the values?(Y/N)");
			String y = sc.next();
			if (y.equals("y") || y.equals("Y")) {
				First first1 = new First();
				file = first1.firstinsert(file);
			}
			return file;
		}

		public int getlimit() {
			// TODO Auto-generated method stub
			try {
				System.out.println("Enter the no of Element you want");
				number = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Limit should be integer so please type correct integer value");
				getlimit();

			}
			return number;
		}
	}
