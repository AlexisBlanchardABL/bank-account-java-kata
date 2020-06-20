import exception.CannotWithdrawMoreThanBalanceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountWithdrawalTest {
    private static final AccountBalance ZERO_BALANCE = new AccountBalance(0.0);

    private BankAccount bankAccount;

    @BeforeEach
    void setup() {
        bankAccount = new BankAccount(new ClockMock());
    }


    @Test
    void given_empty_account_when_withdrawing_money_then_throws_exception() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(ZERO_BALANCE);

        // When
        // Then
        RuntimeException exception = assertThrows(CannotWithdrawMoreThanBalanceException.class, () -> bankAccount.withdraw(500.1));
        assertThat(exception.getMessage()).isEqualTo("You cannot withdraw more money than what's on your account");
    }

    @Test
    void given_some_money_on_account_when_withdrawing_available_money_then_subtract_it() {
        // Given
        bankAccount.makeADeposit(2000.4);

        // When
        bankAccount.withdraw(100);
        bankAccount.withdraw(50);

        // Then
        assertThat(bankAccount.getBalance()).isEqualTo(new AccountBalance(1850.4));
    }

}
