public abstract class BankOperation {
    protected Amount amount;

    public BankOperation(Amount amount) {
        this.amount = amount;
    }

    public abstract AccountBalance computeNewBalance(AccountBalance currentBalance);

}
