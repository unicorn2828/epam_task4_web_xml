package test.kononov.parsing.validator;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import by.kononov.parsing.validator.GemErrorHandler;

public class ErrorHandlerTest{
	private GemErrorHandler errorHandler;
	private SAXParseException exception;

	@BeforeClass
	public void setUp() {
		errorHandler = new GemErrorHandler();
		exception = new SAXParseException("test", "test", "test", 2, 2);
	}

	@AfterClass
	public void tierDown() {
		errorHandler = null;
		exception = null;
	}

	@Test(expectedExceptions = SAXException.class, description = "GemErrorHandler test")
	public void getLineAddressTest() throws SAXException {
		errorHandler.error(exception);
	}
}