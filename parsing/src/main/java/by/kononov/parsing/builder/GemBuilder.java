package by.kononov.parsing.builder;

import org.xml.sax.SAXException;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;

public abstract class GemBuilder{
	protected Gem gem = new Gem();
	protected Gems gems = new Gems();

	public Gem getGem() {
		return gem;
	}

	public Gems getGems() {
		return gems;
	}

	public abstract Gems buildGems(String fileName) throws SAXException;
}