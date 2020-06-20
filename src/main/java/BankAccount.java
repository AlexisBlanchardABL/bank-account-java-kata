
public class BankAccount {

    private static final AccountBalance ZERO_BALANCE = new AccountBalance(0.0);

    private AccountBalance balance;

    public BankAccount() {
        balance = ZERO_BALANCE;
    }

    public void makeADeposit(double amount) {
        Deposit deposit = new Deposit(Amount.ofValue(amount));

        makeABankOperation(deposit);
    }

    public void withdraw(double amount) {
        Withdrawal withdrawal = new Withdrawal(Amount.ofValue(amount), getBalance());
        makeABankOperation(withdrawal);
    }

    private void makeABankOperation(BankOperation operation) {
        this.balance = operation.computeNewBalance(getBalance());
    }

    public AccountBalance getBalance() {
        return balance;
    }

}
