import exception.CannotWithdrawMoreThanBalanceException;

import java.time.LocalDateTime;

public class Withdrawal extends BankOperation {

    public Withdrawal(Amount amount, AccountBalance currentBalance, LocalDateTime date) {
        super(amount, date);
        if (currentBalance.cannotWithdraw(amount)) {
            throw new CannotWithdrawMoreThanBalanceException();
        }
    }

    public AccountBalance computeNewBalance(AccountBalance currentBalance) {
        return currentBalance.subtract(amount);
    }

    @Override
    public OperationType getOperationType() {
        return OperationType.WITHDRAWAL;
    }

}
