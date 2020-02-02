package by.kononov.parsing.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * This is the XsdValidator class; it is used to check the xml file
 * with xsd schema.
 * 
 * @author Vitaly Kononov
 * @since 2019-12-14
 */
public class XmlValidator{
	final static Logger logger = LogManager.getLogger();
	private static final String DEFAULT_XSD_SCHEMA = "d:\\uploads\\xml\\gems.xsd";
	private static final String DEFAULT_VALUE = "default";

	private XmlValidator() {
		super();
	}

	public static boolean isValidateBySchema(String filePath, String schemaPath) {
		boolean status = false;
		if (DEFAULT_VALUE.equals(schemaPath)) {
			schemaPath = DEFAULT_XSD_SCHEMA;
		}
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		File schemaLocation = new File(schemaPath);
		try {
			Schema schema = factory.newSchema(schemaLocation);
			Validator validator = schema.newValidator();
			validator.setErrorHandler(new GemErrorHandler());
			Source source = new StreamSource(filePath);
			validator.validate(source);
			status = true;
		} catch (SAXException e) {
			logger.error("validation {} is not valid because {}", filePath, e.getMessage());
		} catch (IOException e) {
			logger.error("can't read xml file {}", filePath, e);
		}
		return status;
	}
}