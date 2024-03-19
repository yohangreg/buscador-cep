package exception;

public class ManyNumbersCepException extends RuntimeException {
    private String message;
    @Override
    public String getMessage() {
        return this.message;
    }

    public ManyNumbersCepException(String message) {
        this.message = message;
    }
}
