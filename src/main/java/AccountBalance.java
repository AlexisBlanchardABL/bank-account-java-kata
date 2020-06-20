import java.math.MathContext;
import java.util.Objects;

import static java.math.BigDecimal.valueOf;

public class AccountBalance {

    private double balance;

    public AccountBalance(double balance) {
        this.balance = balance;
    }

    AccountBalance add(Amount amount) {
        return new AccountBalance(
                valueOf(balance).add(valueOf(amount.getValue()), new MathContext(5)).doubleValue()
        );
    }

    AccountBalance subtract(Amount amount) {
        return new AccountBalance(
                valueOf(balance).subtract(valueOf(amount.getValue()), new MathContext(5)).doubleValue()
        );
    }

    boolean cannotWithdraw(Amount amount) {
        return amount.getValue() > balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountBalance)) return false;
        AccountBalance that = (AccountBalance) o;
        return Double.compare(that.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

}
