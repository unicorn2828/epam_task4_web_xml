package test.kononov.parsing.service;

import static org.testng.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.entity.Parameters;
import by.kononov.parsing.service.ParsingCommandLogic;
import by.kononov.parsing.type.BuilderType;

public class ParsingLogicTest{
	private static final String XML_FILE = "src/main/resources/data/testData/gemsTest.xml";
	private Gems actual = new Gems();
	private Gems expected = new Gems();

	@BeforeTest(description = "it creates an expected item and writes it to	the xml file")
	public void setUp() {
		Gem gem = new Gem();
		gem.setName("test");
		gem.setValue(10);
		gem.setOrigin("test");
		gem.setDate(LocalDateTime.parse("2020-01-20T19:21"));
		gem.setPreciousness("test");
		Parameters parameters = new Parameters("test", 10, 10);
		gem.setParameters(parameters);
		expected.add(gem);
	}

	@Test(description = "ParsingCommandLogic.class receiveGemList() method test")
	public void receiveGemListTest() throws SAXException {
		List<Gem> test = ParsingCommandLogic.receiveGemList(BuilderType.DOM, XML_FILE);
		for (Gem gem : test) {
			actual.add(gem);
		}
		assertEquals(actual, expected);
	}
}