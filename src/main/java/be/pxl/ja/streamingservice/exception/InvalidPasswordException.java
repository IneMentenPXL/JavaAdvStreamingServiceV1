package be.pxl.ja.streamingservice.exception;

public class InvalidPasswordException extends Exception {
	public InvalidPasswordException() {
		super("Password not correct.");
	}
}
