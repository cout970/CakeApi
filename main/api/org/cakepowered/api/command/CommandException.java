package org.cakepowered.api.command;

public class CommandException extends Exception{

	private final String message;
	
	public CommandException() {
        this.message = null;
    }
	
	public CommandException(String message) {
        this.message = message;
    }
	
	public CommandException(String message, Throwable throwable) {
        super(throwable);
        this.message = message;
    }
	
	public String getMessage() {
        return message;
    }
	
	public String getLocalizedMessage() {
        return getMessage();
    }
}
