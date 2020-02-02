package test.kononov.parsing.command;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.command.impl.ParsingCommand;
import by.kononov.parsing.exception.CustomException;

public class ParsingCommandTest{
	private static final String EXPECTED_PAGE = "/index.jsp";
	private static final String PARSER = "DOM";
	private Command command;
	@Mock
	private HttpServletRequest request;

	@BeforeTest
	void setUp() {
		MockitoAnnotations.initMocks(this);
		command = new ParsingCommand();
	}

	@AfterTest
	void setDown() {
		command = null;
		request = null;
	}

	@Test(description = "positive ParsingCommand.class test; use mock")
	public void executeTest() throws ServletException, IOException, CustomException {
		Mockito.when(request.getParameter(Matchers.anyString())).thenReturn(PARSER).thenReturn("test", "test");
		String actual = command.execute(request);
		Mockito.verify(request, Mockito.times(2)).getParameter(Matchers.anyString());
		assertEquals(actual, EXPECTED_PAGE);
	}
}