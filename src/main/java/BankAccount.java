import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static final AccountBalance ZERO_BALANCE = new AccountBalance(0.0);

    private List<BankOperation> operations = new ArrayList<>();
    private Clock clock;

    public BankAccount(Clock clock) {
        this.clock = clock;
    }

    public void makeADeposit(double amount) {
        Deposit deposit = new Deposit(Amount.ofValue(amount), LocalDateTime.now(clock));
        makeABankOperation(deposit);
    }

    public void withdraw(double amount) {
        Withdrawal withdrawal = new Withdrawal(Amount.ofValue(amount), getBalance(), LocalDateTime.now(clock));
        makeABankOperation(withdrawal);
    }

    public void printStatement() {
        if (operations.isEmpty()) {
            System.out.println("No operations done yet. Balance: 0");
        }
        AccountBalance balance = ZERO_BALANCE;

        for (BankOperation operation : operations) {
            balance = operation.computeNewBalance(balance);
            System.out.println(operation.formatOperation(balance));
        }
    }

    public AccountBalance getBalance() {
        AccountBalance balance = ZERO_BALANCE;
        for (BankOperation operation : operations) {
            balance = operation.computeNewBalance(balance);
        }
        return balance;
    }

    private void makeABankOperation(BankOperation operation) {
        operations.add(operation);
    }

}
