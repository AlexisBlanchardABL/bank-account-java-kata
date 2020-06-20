
public class BankAccount {

    private double balance;

    public void makeADeposit(double amount) {
        verifyNonNegativeValue(amount);

        balance += amount;
    }

    public void withdraw(double amount) {
        verifyNonNegativeValue(amount);
        if (amount > getBalance()) {
            throw new RuntimeException("You can't withdraw more money that what's on your account");
        }

        balance -= amount;
    }

    private void verifyNonNegativeValue(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Do not accept <= 0 values");
        }
    }

    public double getBalance() {
        return balance;
    }

}
