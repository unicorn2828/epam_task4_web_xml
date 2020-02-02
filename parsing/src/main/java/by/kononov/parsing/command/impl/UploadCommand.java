package by.kononov.parsing.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.exception.CustomException;
import by.kononov.parsing.manager.ConfigurationManager;
import by.kononov.parsing.service.UploadCommandLogic;

public class UploadCommand implements Command{
	final static Logger logger = LogManager.getLogger();
	private static final String PAGE = "path.page.upload_result";
	private static final String ERROR_PAGE = "path.page.error";
	private static final String ATTRIBUTE_FILE = "file";
	private static final String ATTRIBUTE_RESULT = "result";
	private static final String RESULT_POSITIVE = "FILE UPLOADED SUCCESSFULLY";
	private static final String RESULT_NEGATIVE = "WARNING! UPLOADED FAILED";

	@Override
	public String execute(HttpServletRequest request) throws ServletException {
		try {
			Part filePart = request.getPart(ATTRIBUTE_FILE);
			request.setAttribute(ATTRIBUTE_RESULT, RESULT_POSITIVE);
			request.setAttribute(ATTRIBUTE_FILE, UploadCommandLogic.receiveFileName(filePart));
		} catch (IOException e) {
			logger.error("can't write xml file", e);
			request.setAttribute(ATTRIBUTE_RESULT, RESULT_NEGATIVE);
		} catch (CustomException e) {
			request.setAttribute("exception", e.getMessage());
			return ConfigurationManager.getProperty(ERROR_PAGE);
		}
		return ConfigurationManager.getProperty(PAGE);
	}
}