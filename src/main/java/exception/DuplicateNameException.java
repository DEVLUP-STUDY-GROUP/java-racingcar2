package exception;

public class DuplicateNameException extends RuntimeException {
    public DuplicateNameException(String errorMessage) {
        super(errorMessage);
    }
}
