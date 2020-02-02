package by.kononov.parsing.command.impl;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.entity.Gem;
import by.kononov.parsing.manager.ConfigurationManager;
import by.kononov.parsing.service.ParsingCommandLogic;
import by.kononov.parsing.type.BuilderType;

public class ParsingCommand implements Command{
	final static Logger logger = LogManager.getLogger();
	private static final String PAGE = "path.page.show_all";
	private static final String ATTRIBUTE_GEMS = "gems";
	private static final String PARSER_TYPE = "parser";
	private static final String PARAMETER_MENU = "menu";
	private static final String PARAMETER_FILE_PATH = "filePath";

	@Override
	public String execute(HttpServletRequest request) throws ServletException {
		BuilderType parserType = BuilderType.valueOf(request.getParameter(PARAMETER_MENU));
		request.setAttribute(PARSER_TYPE, parserType);
		String fileName = request.getParameter(PARAMETER_FILE_PATH);
		List<Gem> list = ParsingCommandLogic.receiveGemList(parserType, fileName);
		request.setAttribute(ATTRIBUTE_GEMS, list);
		return ConfigurationManager.getProperty(PAGE);
	}
}