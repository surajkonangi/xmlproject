package com.xml;
	import java.io.IOException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.xpath.XPathExpressionException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Search {
		static Scanner sc = new Scanner(System.in);
		int idvalue = 0;

		void SearchById(NodeList nodelist, Document document) throws XPathExpressionException, ParserConfigurationException,
				SAXException, IOException, TransformerException {
			int Employee_id = 0;
			Employee_id = getEmp_id();
			NodeList nodelist1 = document.getElementsByTagName("*");
			int size = filter.filtering(nodelist1);
			size = 1 + size;
			int temp = 0;
			for (int count = 0; count < nodelist.getLength(); count++) {
				if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodelist.item(count);
					if (eElement.getAttribute("id").equals(Integer.toString(Employee_id))) {

						System.out.println("id :" + eElement.getAttribute("id"));
						for (int count2 = 2; count2 <= size; count2++) {
							Element element = (Element) nodelist1.item(count2);
							temp++;
							try {
								System.out.println(element.getNodeName() + ":"
										+ eElement.getElementsByTagName(element.getNodeName()).item(0).getTextContent());
							} catch (NullPointerException e) {
								sc.nextLine();
							}
						}
					}
				}
			}
			if (temp == 0) {
				System.out.println("No matching records is found");
			}
		}

		void SearchByName(NodeList nodelist, Document document) {
			System.out.println("Enter the Employee Name");
			String Employee_name = sc.next();
			NodeList nodelist1 = document.getElementsByTagName("*");
			int size = filter.filtering(nodelist1);
			size = 1 + size;
			int temp = 0;
			for (int count = 0; count < nodelist.getLength(); count++) {
				if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodelist.item(count);
					Element element1 = (Element) nodelist1.item(2);
					if (eElement.getElementsByTagName(element1.getNodeName()).item(0).getTextContent()
							.equals(Employee_name)) {
						temp++;
						System.out.println("id :" + eElement.getAttribute("id"));
						for (int count2 = 2; count2 <= size; count2++) {
							Element element = (Element) nodelist1.item(count2);
							try {
								System.out.println(element.getNodeName() + ":"
										+ eElement.getElementsByTagName(element.getNodeName()).item(0).getTextContent());
							} catch (NullPointerException e) {

								System.out.println();
							}
						}
					}
				}
			}
			if (temp == 0) {
				System.out.println("name is not matching with any record or incorrect name");
			}
		}

		void SearchALL(NodeList nodelist, Document document) {
			System.out.println("Employee Details");
			NodeList nodelist1 = document.getElementsByTagName("*");
			int size = filter.filtering(nodelist1);
			size = 1 + size;
			for (int count = 0; count < nodelist.getLength(); count++) {
				if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodelist.item(count);
					System.out.println("id :" + eElement.getAttribute("id"));
					for (int count2 = 2; count2 <= size; count2++) {
						Element element = (Element) nodelist1.item(count2);
						try {
							System.out.println(element.getNodeName() + ":"
									+ eElement.getElementsByTagName(element.getNodeName()).item(0).getTextContent());
						} catch (NullPointerException e) {
							System.out.println();
						}
					}
				}
			}
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
