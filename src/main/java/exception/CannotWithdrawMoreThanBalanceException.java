package exception;

public class CannotWithdrawMoreThanBalanceException extends RuntimeException {

    public CannotWithdrawMoreThanBalanceException() {
        super("You cannot withdraw more money than what's on your account");
    }

}
