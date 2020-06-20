import exception.CannotWithdrawMoreThanBalanceException;

public class Withdrawal extends BankOperation {

    public Withdrawal(Amount amount, AccountBalance currentBalance) {
        super(amount);
        if (currentBalance.cannotWithdraw(amount)) {
            throw new CannotWithdrawMoreThanBalanceException();
        }
    }

    public AccountBalance computeNewBalance(AccountBalance currentBalance) {
        return currentBalance.subtract(amount);
    }

}
