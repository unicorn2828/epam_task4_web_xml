package by.kononov.parsing.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class GemErrorHandler extends DefaultHandler{
	final static Logger logger = LogManager.getLogger();

	@Override
	public void warning(SAXParseException e) throws SAXException {
		logger.warn("{} - {}", getLineAddress(e), e.getMessage());
		throw new SAXException(e);
	}

	@Override
	public void error(SAXParseException e) throws SAXException {
		logger.error("{} - {}", getLineAddress(e), e.getMessage());
		throw new SAXException(e);
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		logger.fatal("{} -> {}", getLineAddress(e), e.getMessage());
		throw new SAXException(e);
	}

	private String getLineAddress(SAXParseException e) {
		return e.getLineNumber() + " : " + e.getColumnNumber();
	}
}