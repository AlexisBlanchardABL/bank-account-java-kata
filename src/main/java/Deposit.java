public class Deposit extends BankOperation {

    public Deposit(Amount amount) {
        super(amount);
    }

    public AccountBalance computeNewBalance(AccountBalance currentBalance) {
        return currentBalance.add(amount);
    }
}
