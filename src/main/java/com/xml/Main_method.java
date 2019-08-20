package com.xml;
	import java.io.IOException;

	import javax.xml.parsers.ParserConfigurationException;
	import javax.xml.transform.TransformerException;
	import javax.xml.xpath.XPathExpressionException;

	import org.xml.sax.SAXException;

	public class Main_method {
		public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException,
				TransformerException, SAXException, IOException {
			App app = new App();
			app.Menu();
		}

}
