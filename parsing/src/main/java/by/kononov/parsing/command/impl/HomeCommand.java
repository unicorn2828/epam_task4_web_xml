package by.kononov.parsing.command.impl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.manager.ConfigurationManager;

public class HomeCommand implements Command{
	private static final String PAGE = "path.page.index";

	@Override
	public String execute(HttpServletRequest request) throws ServletException {
		return ConfigurationManager.getProperty(PAGE);
	}
}
