package test.kononov.parsing.factory;

import static org.testng.Assert.assertEquals;

import java.time.LocalDateTime;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.entity.Gems;
import by.kononov.parsing.entity.Parameters;
import by.kononov.parsing.factory.BuilderFactory;
import by.kononov.parsing.type.BuilderType;

public class BuilderFactoryTest{
	private static final String XML_FILE = "src/main/resources/data/testData/gemsTest.xml";
	private BuilderFactory parsingFactory;
	private Gems actual;
	private Gems expected;

	@BeforeTest(description = "it creates an expected item and writes it to	the xml file")
	public void setUp() {
		parsingFactory = new BuilderFactory();
		Gem gem = new Gem();
		actual = new Gems();
		expected = new Gems();
		gem.setName("test");
		gem.setValue(10);
		gem.setOrigin("test");
		gem.setDate(LocalDateTime.parse("2020-01-20T19:21"));
		gem.setPreciousness("test");
		Parameters parameters = new Parameters("test", 10, 10);
		gem.setParameters(parameters);
		expected.add(gem);
	}

	@AfterClass
	public void tierDown() {
		parsingFactory = null;
		actual = null;
		expected = null;
	}

	@Test(description = "Gems DOM_Builder test")
	public void buildGemsDOMBuilderTest() throws SAXException {
		actual = parsingFactory.createGemsBuilder(BuilderType.DOM, XML_FILE);
		assertEquals(actual, expected);
	}

	@Test(description = "Gems SAX_Builder test")
	public void buildGemsSAXBuilderTest() throws SAXException {
		actual = parsingFactory.createGemsBuilder(BuilderType.SAX, XML_FILE);
		assertEquals(actual, expected);
	}

	@Test(description = "Gems StAX_Builder test without Name and Preciousness fields")
	public void buildGemsStAXBuilderTest() throws SAXException {
		actual = parsingFactory.createGemsBuilder(BuilderType.STAX, XML_FILE);
		Gems staxExpected = new Gems();
		Gem gem = new Gem();
		gem.setValue(10);
		gem.setOrigin("test");
		gem.setDate(LocalDateTime.parse("2020-01-20T19:21"));
		Parameters parameters = new Parameters("test", 10, 10);
		gem.setParameters(parameters);
		staxExpected.add(gem);
		assertEquals(actual, staxExpected);
	}
}