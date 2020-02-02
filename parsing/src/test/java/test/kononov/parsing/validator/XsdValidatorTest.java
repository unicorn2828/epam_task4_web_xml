package test.kononov.parsing.validator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import by.kononov.parsing.validator.XmlValidator;

public class XsdValidatorTest{
	private static final String XML_FILE = "src/main/resources/data/gems.xml";
	private static final String TEST_FILE = "src/main/resources/data/gemsNotValid.xml";
	private static final String XSD_SCHEMA = "src/main/resources/data/gems.xsd";

	@Test(description = "validation of xsd")
	public void validatePositiveXSD() {
		boolean condition = XmlValidator.isValidateBySchema(XML_FILE, XSD_SCHEMA);
		assertTrue(condition);
	}

	@Test(description = "validation of xsd")
	public void validateNegativeXSD() {
		boolean condition = XmlValidator.isValidateBySchema(TEST_FILE, XSD_SCHEMA);
		assertFalse(condition);
	}
}