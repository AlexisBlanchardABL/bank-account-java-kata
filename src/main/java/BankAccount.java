
public class BankAccount {

    private double balance;

    public void makeADeposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Do not accept <= 0 values");
        }

        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

}
