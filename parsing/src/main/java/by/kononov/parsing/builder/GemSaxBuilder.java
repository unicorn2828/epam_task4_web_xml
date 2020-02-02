package by.kononov.parsing.builder;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import by.kononov.parsing.entity.Gems;

public class GemSaxBuilder extends GemBuilder{
	final static Logger logger = LogManager.getLogger();

	@Override
	public Gems buildGems(String fileName) {
		GemHandler handler = new GemHandler();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		try {
			saxParser = factory.newSAXParser();
			saxParser.parse(fileName, handler);
		} catch (SAXException | ParserConfigurationException e) {
			logger.error("parsing esception", e);
		} catch (IOException e) {
			logger.error("can't read file " + fileName, e);
		}
		return handler.getGems();
	}
}