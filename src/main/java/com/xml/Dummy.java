package com.xml;
	import java.io.IOException;
	import java.util.Scanner;

	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
	import org.xml.sax.SAXException;

	public class Dummy
	{
		static Document delete(Document doc, int Emp)
				throws ParserConfigurationException, SAXException, IOException, TransformerException {
			int Employee_id = 0, temp = 0;
			Scanner sc = new Scanner(System.in);
			doc.getDocumentElement().normalize();
			Element Employe = doc.getDocumentElement();
			NodeList nodelist = Employe.getChildNodes();
			Employee_id = Emp;
			for (int count = 0; count < nodelist.getLength(); count++) {
				if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodelist.item(count);
					if (eElement.getAttribute("id").equals(Integer.toString(Employee_id))) {
						temp++;
						eElement.getParentNode().removeChild(eElement);
					}
				}
			}
			if (temp == 0) {
				System.out.println("id is not available");
			}
			return doc;

		}

		static int delete1(Document doc, int Emp)
				throws ParserConfigurationException, SAXException, IOException, TransformerException {
			int Employee_id = 0, temp = 0;
			Scanner sc = new Scanner(System.in);
			doc.getDocumentElement().normalize();
			Element Employe = doc.getDocumentElement();
			NodeList nodelist = Employe.getChildNodes();
			Employee_id = Emp;
			for (int count = 0; count < nodelist.getLength(); count++) {
				if (nodelist.item(count).getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nodelist.item(count);
					if (eElement.getAttribute("id").equals(Integer.toString(Employee_id))) {
						temp++;
					}
				}
			}
			return temp;

		}

}
