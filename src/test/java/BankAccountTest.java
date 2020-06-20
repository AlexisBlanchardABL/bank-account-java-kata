import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount();
    }

    @Test
    void given_empty_account_operation_when_making_a_deposit_then_deposit_amount_is_added_to_the_balance() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(0);

        // When
        bankAccount.makeADeposit(500);

        // Then
        assertThat(bankAccount.getBalance()).isEqualTo(500);
    }

    @Test
    void given_empty_account_when_making_two_deposits_then_deposits_amounts_are_added_to_the_balance() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(0);

        // When
        bankAccount.makeADeposit(500);
        bankAccount.makeADeposit(750.2);

        // Then
        assertThat(bankAccount.getBalance()).isEqualTo(1250.2);
    }

    @Test
    void should_throw_an_exception_when_making_a_deposit_with_negative_value() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> bankAccount.makeADeposit(-1000));

        assertThat(exception.getMessage()).isEqualTo("Do not accept <= 0 values");
    }

}
