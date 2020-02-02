package by.kononov.parsing.factory;

import by.kononov.parsing.builder.GemDomBuilder;
import by.kononov.parsing.builder.GemSaxBuilder;
import by.kononov.parsing.builder.GemStaxBuilder;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.type.BuilderType;

public class BuilderFactory{

	public Gems createGemsBuilder(BuilderType parserType, String fileName) {
		switch (parserType) {
			case DOM:
				return new GemDomBuilder().buildGems(fileName);
			case SAX:
				return new GemSaxBuilder().buildGems(fileName);
			case STAX:
				return new GemStaxBuilder().buildGems(fileName);
			default:
				throw new EnumConstantNotPresentException(parserType.getDeclaringClass(), parserType.name());
		}
	}
}