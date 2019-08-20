package com.xml;
	import java.io.File;
	import java.io.IOException;
	import java.util.InputMismatchException;
	import java.util.Scanner;

	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.xpath.XPathExpressionException;

	import org.xml.sax.SAXException;

	/**
	 * Hello world!
	 *
	 */
	public class App {
		static File file = new File("C:\\Users\\Suraj.konangi\\eclipse-workspace\\test\\testng.xml");
		static int choice;

		static void Menu() throws ParserConfigurationException, TransformerException, SAXException, IOException,
				XPathExpressionException {
			while (true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("***********************Xml File Operation******************");
				System.out.println(" 1)create \n 2)Insert \n 3)delete \n 4)search \n 5)update");
				System.out.println("choose operation");
				System.out.println("============================================================");
				try {
					choice = sc.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Please enter the integer options");
					sc.nextLine();
					Menu();
				}
				switch (choice) {
				case 1:
					if (file.exists()) {
						System.out.println("file already exists");
					} else {
						Createxml creater = new Createxml();
						file = creater.createXMl();
					}
					break;
				case 2:
					if (file.exists()) {
						Inserter ins = new Inserter();
						ins.insertion(file);
					} else {
						System.out.println("File is not created go and create file");
					}
					break;
				case 3:
					if (file.exists()) {
						Remover remover = new Remover();
						remover.delete(file);
					} else {
						System.out.println("File is not created go and create file");
					}
					break;
				case 4:
					if (file.exists()) {
						Selector selector = new Selector();
						selector.search(file);
					} else {
						System.out.println("File is not created go and create file");
					}
					break;
				case 5:
					if (file.exists()) {
						Updater updater = new Updater();
						updater.updation(file);
					} else {
						System.out.println("File is not created go and create file");
					}
					break;
				default:
					System.out.println("Please enter the correct choice( like 1,2 etc)");
					break;

				}
			}

		}

}
