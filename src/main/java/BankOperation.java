import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class BankOperation {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    protected Amount amount;
    protected LocalDateTime date;

    public BankOperation(Amount amount, LocalDateTime date) {
        this.amount = amount;
        this.date = date;
    }

    public abstract AccountBalance computeNewBalance(AccountBalance currentBalance);

    public abstract OperationType getOperationType();


    public String formatOperation(AccountBalance accountBalance) {
        return DATE_TIME_FORMATTER.format(date) + ": " +
                getOperationType().getLabel() + ": " + amount.toString() +
                ", Balance: " + accountBalance.getValue();
    }

}
