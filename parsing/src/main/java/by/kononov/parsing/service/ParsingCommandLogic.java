package by.kononov.parsing.service;

import java.util.List;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.factory.BuilderFactory;
import by.kononov.parsing.type.BuilderType;

public class ParsingCommandLogic{

	private ParsingCommandLogic() {
		super();
	}

	public static List<Gem> receiveGemList(BuilderType parserType, String fileName) {
		BuilderFactory parsingFactory = new BuilderFactory();
		Gems gemList = parsingFactory.createGemsBuilder(parserType, fileName);
		return gemList.getGems();
	}
}