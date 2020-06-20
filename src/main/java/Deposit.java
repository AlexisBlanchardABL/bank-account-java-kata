import java.time.LocalDateTime;

public class Deposit extends BankOperation {

    public Deposit(Amount amount, LocalDateTime date) {
        super(amount, date);
    }


    public AccountBalance computeNewBalance(AccountBalance currentBalance) {
        return currentBalance.add(amount);
    }

    public OperationType getOperationType() {
        return OperationType.DEPOSIT;
    }

}
