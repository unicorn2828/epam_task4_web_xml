package by.kononov.parsing.builder;

import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.entity.Parameters;
import by.kononov.parsing.type.GemData;

public class GemHandler extends DefaultHandler{
	final static Logger logger = LogManager.getLogger();
	private GemData element;
	private Gem gem = new Gem();
	private Gems gems = new Gems();
	private Parameters parameters;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) {
		element = GemData.valueOf(qName.toUpperCase());
		if (GemData.GEM.equals(element)) {
			gem = new Gem();
			String origin = attributes.getValue(GemData.ORIGIN.getElement());
			gem.setOrigin(origin);
			LocalDateTime date = LocalDateTime.parse(attributes.getValue(GemData.DATE.getElement()));
			gem.setDate(date);
			int value = Integer.parseInt(attributes.getValue(GemData.VALUE.getElement()));
			gem.setValue(value);
			gems.add(gem);
		} else if (GemData.PARAMETERS.equals(element)) {
			parameters = new Parameters();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		if ("gem".equals(localName)) {
			gems.add(gem);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		String content = new String(ch, start, length).trim();
		if (element != null && element != GemData.GEM && element != GemData.GEMS) {
			switch (element) {
				case NAME:
					gem.setName(content);
					break;
				case PRECIOUSNESS:
					gem.setPreciousness(content);
					break;
				case COLOR:
					parameters.setColor(content);
					break;
				case TRANSPARENCE:
					parameters.setTransparence(Integer.parseInt(content));
					break;
				case FACETS:
					parameters.setFacets(Integer.parseInt(content));
					break;
				case PARAMETERS:
					gem.setParameters(parameters);
					break;
				default:
					throw new EnumConstantNotPresentException(element.getDeclaringClass(), element.name());
			}
		}
		element = null;
	}

	public Gems getGems() {
		return gems;
	}
}