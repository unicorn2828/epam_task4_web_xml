package by.kononov.parsing.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.manager.ConfigurationManager;
import by.kononov.parsing.service.CommandProvider;

@WebServlet("/controller")
@MultipartConfig
public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PAGE = "path.page.index";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		Command command = CommandProvider.defineCommand(request);
		page = command.execute(request);
		if (page != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
			dispatcher.forward(request, response);
		} else {
			page = ConfigurationManager.getProperty(INDEX_PAGE);
			response.sendRedirect(request.getContextPath() + page);
		}
	}
}