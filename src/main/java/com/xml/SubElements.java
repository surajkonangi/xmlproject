package com.xml;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;

	public class SubElements {
		static String username;
		static Scanner sc = new Scanner(System.in);
		int idvalue, number = 0;;

		static Document SubElements(NodeList nodelist, Document document, Element subEle) {
			int size = filter.filtering(nodelist);
			size = size + 1;
			int Elementnumber = 1;
			for (int count2 = 2; count2 < size; count2++) {
				Element element = (Element) nodelist.item(count2);
				System.out.println("Enter the " + Elementnumber + " sub Element " + element.getNodeName());
				username = sc.next();
				Element childEle1 = document.createElement(element.getNodeName());
				childEle1.appendChild(document.createTextNode(username));
				subEle.appendChild(childEle1);
				Elementnumber++;
			}
			return document;
		}

		public int getlimit() {
			// TODO Auto-generated method stub
			try {
				System.out.println("Enter the no of Records");
				number = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(" Limit should be integer so please type correct integer value");
				sc.nextLine();
				getlimit();

			}
			return number;
		}

		public int getEmp_id() {

			try {

				System.out.println("Enter the id value");
				idvalue = sc.nextInt();
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.println("Id should be integer type correct integer value");
				getEmp_id();
			}
			return idvalue;
		}
}
