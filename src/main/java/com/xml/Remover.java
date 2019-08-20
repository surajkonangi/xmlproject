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

	public class Remover {
		Scanner sc = new Scanner(System.in);
		int Employee_id = 0, temp = 0, idvalue = 0;

		void delete(File file) throws ParserConfigurationException, SAXException, IOException, TransformerException,
				XPathExpressionException {

			int n = filter.Empty(file);

			FileInputStream fileInputStream = new FileInputStream(file);
			DocumentBuilderFactory documentbuildfact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentbuild = documentbuildfact.newDocumentBuilder();
			Document document = documentbuild.parse(fileInputStream);
			document.getDocumentElement().normalize();
			Element Employe = document.getDocumentElement();
			NodeList nodelist = Employe.getChildNodes();
			if (n > 2 && nodelist.getLength() == 1) {
				System.out.println("database is empty");
			} else {
				Employee_id = getEmp_id();
				if (nodelist.getLength() == 1) {
					temp++;
					int variable = Dummy.delete1(document, Employee_id);
					if (variable != 0) {
						System.out.println("Successfully Deleted :" + Employee_id);
						document = Deletexml.deletevalues();
					}
					document = Dummy.delete(document, Employee_id);

				} else {
					for (int count = 0; count < nodelist.getLength(); count++) {
						if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
							Element eElement = (Element) nodelist.item(count);
							if (eElement.getAttribute("id").equals(Integer.toString(Employee_id))) {

								temp++;
								eElement.getParentNode().removeChild(eElement);
								System.out.println("successfully deleted : " + eElement.getAttribute("id"));
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
