package by.kononov.parsing.type;

import by.kononov.parsing.command.Command;
import by.kononov.parsing.command.impl.HomeCommand;
import by.kononov.parsing.command.impl.ParsingCommand;
import by.kononov.parsing.command.impl.UploadCommand;

public enum CommandType {
	UPLOAD(new UploadCommand()), HOME(new HomeCommand()), PARSING(new ParsingCommand());

	private Command command;

	CommandType(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return command;
	}
}