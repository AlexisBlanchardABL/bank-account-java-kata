import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AccountBalanceTest {

    @Test
    void given_a_balance_when_add_amount_then_returns_addition_of_balance_and_amount() {
        // Given
        AccountBalance accountBalance = new AccountBalance(4300.4);

        // When
        AccountBalance result = accountBalance.add(Amount.ofValue(400.8));

        // Then
        assertThat(result).isEqualTo(new AccountBalance(4701.2));
    }

    @Test
    void given_a_balance_when_subtract_amount_then_returns_subtraction_of_balance_and_amount() {
        // Given
        AccountBalance accountBalance = new AccountBalance(4300.4);

        // When
        AccountBalance result = accountBalance.subtract(Amount.ofValue(400.8));

        // Then
        assertThat(result).isEqualTo(new AccountBalance(3899.6));
    }

    @ParameterizedTest(name = "With {0} on your account, a withdraw of {1} is forbidden: {2}")
    @CsvSource(value = {
            "0|10|true",
            "-500.4|0.001|true",
            "1500.7|100000|true",
            "100.5|0.5|false"
    }, delimiter = '|')
    void given_balance_and_amount_when_checking_whether_the_withdraw_is_forbidden_then_returns_true_or_false(
            double balance, double amountValue, boolean isWithdrawForbidden
    ) {
        // Given
        AccountBalance accountBalance = new AccountBalance(balance);
        Amount amount = Amount.ofValue(amountValue);

        // When
        boolean result = accountBalance.cannotWithdraw(amount);

        // Then
        assertThat(result).isEqualTo(isWithdrawForbidden);
    }

}
