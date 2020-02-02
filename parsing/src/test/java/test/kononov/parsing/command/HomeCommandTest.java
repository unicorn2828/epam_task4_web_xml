package test.kononov.parsing.command;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.command.impl.HomeCommand;
import by.kononov.parsing.exception.CustomException;

public class HomeCommandTest{
	private static final String EXPECTED = "/index.jsp";
	private Command command;
	@Mock
	private HttpServletRequest request;

	@BeforeTest
	void setUp() {
		MockitoAnnotations.initMocks(this);
		command = new HomeCommand();
	}

	@AfterTest
	void setDown() {
		command = null;
		request = null;
	}

	@Test(description = "positive BackCommand.class test; use mock")
	public void executeTest() throws ServletException, IOException, CustomException {
		String actual = command.execute(request);
		assertEquals(actual, EXPECTED);
	}
}