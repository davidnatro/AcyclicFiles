package application.exceptions;

public class CyclicGraphException extends Exception {
    public CyclicGraphException(String message) {
        super(message);
    }
}
