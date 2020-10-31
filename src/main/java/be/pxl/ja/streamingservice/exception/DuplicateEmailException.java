package be.pxl.ja.streamingservice.exception;

public class DuplicateEmailException extends Exception{
    public DuplicateEmailException() {
        super("Duplicate email.");
    }
}
