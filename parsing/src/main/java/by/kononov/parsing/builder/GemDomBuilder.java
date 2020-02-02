package by.kononov.parsing.builder;

import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.entity.Parameters;
import by.kononov.parsing.type.GemData;

public class GemDomBuilder extends GemBuilder{
	final static Logger logger = LogManager.getLogger();

	@Override
	public Gems buildGems(String fileName) {
		DOMParser parser = new DOMParser();
		Element element;
		try {
			parser.parse(fileName);
			Document document = parser.getDocument();
			Element root = document.getDocumentElement();
			NodeList gemNodes = root.getElementsByTagName(GemData.GEM.getElement());
			for (int i = 0; i < gemNodes.getLength(); i++) {
				element = (Element) gemNodes.item(i);
				gem = buildGem(element);
				gems.add(gem);
			}
		} catch (SAXException | IOException e) {
			logger.error("can't parse xml file " + fileName, e);
		}
		return gems;
	}

	public Gem buildGem(Element element) {
		Gem gem = new Gem();
		NodeList gemName = element.getElementsByTagName(GemData.NAME.getElement());
		String name = gemName.item(0).getTextContent();
		gem.setName(name);
		NodeList gemPreciousnes = element.getElementsByTagName(GemData.PRECIOUSNESS.getElement());
		String preciousnes = gemPreciousnes.item(0).getTextContent();
		gem.setPreciousness(preciousnes);
		String origin = element.getAttribute(GemData.ORIGIN.getElement());
		gem.setOrigin(origin);
		LocalDateTime date = LocalDateTime.parse(element.getAttribute(GemData.DATE.getElement()));
		gem.setDate(date);
		int value = Integer.parseInt(element.getAttribute(GemData.VALUE.getElement()));
		gem.setValue(value);
		NodeList gemColor = element.getElementsByTagName(GemData.COLOR.getElement());
		String color = gemColor.item(0).getTextContent();
		NodeList gemTransparence = element.getElementsByTagName(GemData.TRANSPARENCE.getElement());
		int transparence = Integer.parseInt(gemTransparence.item(0).getTextContent());
		NodeList gemFacets = element.getElementsByTagName(GemData.FACETS.getElement());
		int facets = Integer.parseInt(gemFacets.item(0).getTextContent());
		Parameters parameters = new Parameters(color, transparence, facets);
		gem.setParameters(parameters);
		return gem;
	}
}