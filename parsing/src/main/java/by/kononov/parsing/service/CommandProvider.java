package by.kononov.parsing.service;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.type.CommandType;

public class CommandProvider{
	final static Logger logger = LogManager.getLogger();
	private static final String PARAMETER_STRING = "action";

	private CommandProvider() {
	}

	public static Command defineCommand(HttpServletRequest request) {
		Command current = CommandType.HOME.getCommand();
		String action = request.getParameter(PARAMETER_STRING);
		if (action == null || action.isEmpty()) {
			return current;
		}
		try {
			CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
			current = currentEnum.getCommand();
		} catch (IllegalArgumentException e) {
			logger.error("ccommand not found or wrong! " + action, e);
		}
		return current;
	}
}