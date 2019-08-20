package com.xml;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.xpath.XPathExpressionException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Selector {
		Scanner sc = new Scanner(System.in);
		int choice;

		void search(File file) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException,
				TransformerException {

			int n = filter.Empty(file);
			if (n > 1) {
				System.out.println("xml file is Empty");
			} else {
				FileInputStream fileInputStream = new FileInputStream(file);
				DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
				Document document = documentbuild.parse(fileInputStream);
				document.getDocumentElement().normalize();
				Element Employe = document.getDocumentElement();
				NodeList nodelist = Employe.getChildNodes();
				System.out.println(" 1)SearchById \n 2)SearchByName \n 3)ShowAll");
				System.out.println("choose operation");
				System.out.println("============================================================");
				try {
					choice = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please enter the integer options");
					sc.nextLine();
					search(file);
				}
				switch (choice) {
				case 1:
					Search search = new Search();
					search.SearchById(nodelist, document);
					break;
				case 2:
					Search search2 = new Search();
					search2.SearchByName(nodelist, document);
					break;
				case 3:
					Search search1 = new Search();
					search1.SearchALL(nodelist, document);
					break;
				default:
					System.out.println("Enter the correct choice(1 or 2  or 3)");
					break;
				}
			}
		}

}
