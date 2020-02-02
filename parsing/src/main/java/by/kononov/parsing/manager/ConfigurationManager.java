package by.kononov.parsing.manager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigurationManager{
	final static Logger logger = LogManager.getLogger();
	private final static String CONFIG_FILE = "properties/config.properties";
	private final static String DEFAULT_JSP_PAGE = "/index.jsp";

	private ConfigurationManager() {
		super();
	}

	public static String getProperty(String key) {
		URL resource = ConfigurationManager.class.getClassLoader().getResource(CONFIG_FILE);
		if (resource == null) {
			logger.warn("can't find properties file " + CONFIG_FILE);
			return DEFAULT_JSP_PAGE;
		}
		File file = new File(resource.getFile());
		ResourceBundle bundle = null;
		try (FileInputStream inputStream = new FileInputStream(file)) {
			InputStreamReader reader = new InputStreamReader(inputStream);
			bundle = new PropertyResourceBundle(reader);
		} catch (IOException e) {
			logger.error("can't read file " + file, e);
		}
		return bundle.getString(key);
	}
}