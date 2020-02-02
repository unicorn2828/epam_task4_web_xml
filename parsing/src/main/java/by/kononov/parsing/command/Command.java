package by.kononov.parsing.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command{
	String execute(HttpServletRequest request) throws ServletException;
}