import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountDepositTest {

    private static final AccountBalance ZERO_BALANCE = new AccountBalance(0.0);

    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
    }

    @Test
    void given_empty_account_operation_when_making_a_deposit_then_deposit_amount_is_added_to_the_balance() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(ZERO_BALANCE);

        // When
        bankAccount.makeADeposit(500);

        // Then
        assertThat(bankAccount.getBalance()).isEqualTo(new AccountBalance(500));
    }

    @Test
    void given_empty_account_when_making_two_deposits_then_deposits_amounts_are_added_to_the_balance() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(ZERO_BALANCE);

        // When
        bankAccount.makeADeposit(500);
        bankAccount.makeADeposit(750.2);

        // Then
        assertThat(bankAccount.getBalance()).isEqualTo(new AccountBalance(1250.2));
    }

}
