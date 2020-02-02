package by.kononov.parsing.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.entity.Parameters;
import by.kononov.parsing.type.GemData;

public class GemStaxBuilder extends GemBuilder{
	final static Logger logger = LogManager.getLogger();

	@Override
	public Gems buildGems(String fileName) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
			XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					String name = reader.getLocalName();
					if (GemData.GEM.equals(GemData.valueOf(name.toUpperCase()))) {
						Gem gem = buildGem(reader);
						gems.add(gem);
					}
				}
			}
		} catch (XMLStreamException e) {
			logger.error("StAX parsing error! ", e);
		} catch (IOException e) {
			logger.error("File can't read " + fileName, e);
		}
		return gems;
	}

	private Gem buildGem(XMLStreamReader reader) throws XMLStreamException {
		Gem gem = new Gem();
		gem.setOrigin(reader.getAttributeValue(null, GemData.ORIGIN.getElement()));
		gem.setDate(LocalDateTime.parse(reader.getAttributeValue(null, GemData.DATE.getElement())));
		gem.setValue(Integer.parseInt(reader.getAttributeValue(null, GemData.VALUE.getElement())));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					switch (GemData.valueOf(name.toUpperCase())) {
						case ORIGIN:
							gem.setOrigin(getXMLText(reader));
							break;
						case DATE:
							gem.setDate(LocalDateTime.parse(getXMLText(reader)));
							break;
						case VALUE:
							gem.setValue(Integer.parseInt(getXMLText(reader)));
							break;
						case PARAMETERS:
							gem.setParameters(buildParameters(reader));
							break;
						default:
							logger.info("Enum constant {} does not present", name);
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					name = reader.getLocalName();
					if (GemData.GEM.equals(GemData.valueOf(name.toUpperCase()))) {
						return gem;
					}
					break;
				default:
					logger.info("Enum constant {} does not present", type);
			}
		}
		throw new XMLStreamException("Unknown element in tag Student");
	}

	private Parameters buildParameters(XMLStreamReader reader) throws XMLStreamException {
		Parameters parameters = new Parameters();
		int type;
		String name;
		while (reader.hasNext()) {
			type = reader.next();
			switch (type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					switch (GemData.valueOf(name.toUpperCase())) {
						case COLOR:
							parameters.setColor(getXMLText(reader));
							break;
						case TRANSPARENCE:
							parameters.setTransparence(Integer.parseInt(getXMLText(reader)));
							break;
						case FACETS:
							parameters.setFacets(Integer.parseInt(getXMLText(reader)));
							break;
						default:
							throw new EnumConstantNotPresentException(
									GemData.valueOf(name.toUpperCase()).getDeclaringClass(),
									GemData.valueOf(name.toUpperCase()).name());
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					name = reader.getLocalName();
					if (GemData.PARAMETERS.equals(GemData.valueOf(name.toUpperCase()))) {
						return parameters;
					}
					break;
				default:
					logger.info("Enum constant {} doesn't present", type);
			}
		}
		throw new XMLStreamException("Unknown element in tag Address");
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}
}