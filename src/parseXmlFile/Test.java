package parseXmlFile;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ParseXmlFileUtil.parseStringToXmlByJdk("<?xml version=\"1.0\" encoding=\"UTF-8\"?><Result>哈哈哈</Result>");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
