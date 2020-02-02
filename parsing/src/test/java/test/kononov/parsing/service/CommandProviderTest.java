package test.kononov.parsing.service;

import static org.testng.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.service.CommandProvider;
import by.kononov.parsing.type.CommandType;

public class CommandProviderTest{
	private Command expected;
	@Mock
	private HttpServletRequest request;

	@BeforeTest
	void setUp() {
		MockitoAnnotations.initMocks(this);
		expected = CommandType.HOME.getCommand();
	}

	@AfterClass
	public void tierDown() {
		expected = null;
		request = null;
	}

	@Test(description = "command factory fest, default command 'HOME'")
	public void defineCommandTest() {
		Command actual = CommandProvider.defineCommand(request);
		assertEquals(actual, expected);
	}
}