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
	import javax.xml.xpath.XPathExpressionException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Updater {
		Scanner sc = new Scanner(System.in);
		// static DOMSource source;
		int idvalue = 0;
		String username;

		void updation(File file) throws ParserConfigurationException, SAXException, IOException, TransformerException,
				XPathExpressionException {
			int n = filter.Empty(file);
			if (n > 2) {
				System.out.println("xml file is Empty");
			} else {
				int Employee_id = 0;
				Scanner sc = new Scanner(System.in);
				FileInputStream fileInputStream = new FileInputStream(file);
				DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
				Document document = documentbuild.parse(fileInputStream);
				document.getDocumentElement().normalize();
				Element Employe = document.getDocumentElement();
				NodeList nodelist1 = Employe.getChildNodes();
				NodeList nodelist = document.getElementsByTagName("*");
				// Element example = (Element) nodelist.item(0);
				Employee_id = getEmp_id();
				int temp = 0;
				if (n > 2 && nodelist1.getLength() == 1) {
					System.out.println("database is empty");
				} else {
					if (nodelist1.getLength() == 1) {
						temp++;
						int variable = Dummy.delete1(document, Employee_id);
						if (variable != 0) {
							document = Deletexml.deletevalues();
							document = Duplicate.insertion(file, Employee_id);
						}
						document = Dummy.delete(document, Employee_id);

					} else {
						int size = filter.filtering(nodelist);
						size = 1 + size;
						int Elementnumber = 1;
						for (int count = 0; count < nodelist1.getLength(); count++) {
							if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) nodelist1.item(count);
								if (eElement.getAttribute("id").equals(Integer.toString(Employee_id))) {
									for (int count2 = 2; count2 < size; count2++) {
										temp++;
										Element element = (Element) nodelist.item(count2);
										System.out.println("Enter the " + Elementnumber + " sub Element value "
												+ element.getNodeName());
										username = sc.next();
										Element childEle1 = (Element) eElement.getElementsByTagName(element.getNodeName())
												.item(0);
										childEle1.setTextContent(username);
										Elementnumber++;
									}
								}
							}
						}
					}
				}

				if (temp == 0) {
					System.out.println("Id is not available");
				}
				DOMSource source = new DOMSource(document);
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StreamResult result = new StreamResult(file);
				transformer.transform(source, result);
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
