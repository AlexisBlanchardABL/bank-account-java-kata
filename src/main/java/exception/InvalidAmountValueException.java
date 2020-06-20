package exception;

public class InvalidAmountValueException extends IllegalArgumentException {
    public InvalidAmountValueException() {
        super("Do not accept <= 0 values");
    }
}
