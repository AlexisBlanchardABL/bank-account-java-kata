import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankAccountPrintStatementTest {
    private static final Instant DEFAULT_DATE = Instant.parse("2020-06-27T19:00:00Z");

    private static final AccountBalance ZERO_BALANCE = new AccountBalance(0.0);

    private BankAccount bankAccount;

    private PrintStream originalOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ClockMock clock;


    @BeforeEach
    void setup() {
        clock = new ClockMock();
        clock.setDate(DEFAULT_DATE);
        bankAccount = new BankAccount(clock);

        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }


    @AfterEach
    public void restoreSystemOut() {
        System.setOut(originalOut);
    }


    @Test
    void given_some_operations_when_checking_operation_history_then_prints_account_statement() {
        // Given
        bankAccount.makeADeposit(2000.4);

        clock.setDate(Instant.parse("2020-06-27T20:00:00Z"));
        bankAccount.withdraw(560.1);

        clock.setDate(Instant.parse("2020-06-28T12:00:00Z"));
        bankAccount.makeADeposit(100.7);

        clock.setDate(Instant.parse("2020-06-29T14:00:00Z"));
        bankAccount.withdraw(333);

        // When
        bankAccount.printStatement();

        // Then
        assertPrinted(
                "2020-06-27 21:00: Deposit: 2000.4, Balance: 2000.4",
                "2020-06-27 22:00: Withdrawal: 560.1, Balance: 1440.3",
                "2020-06-28 14:00: Deposit: 100.7, Balance: 1541.0",
                "2020-06-29 16:00: Withdrawal: 333.0, Balance: 1208.0"
        );
    }

    @Test
    void given_empty_account_when_checking_operation_history_then_prints_no_operations_message() {
        // Given
        assertThat(bankAccount.getBalance()).isEqualTo(ZERO_BALANCE);

        // When
        bankAccount.printStatement();

        // Then
        assertPrinted("No operations done yet. Balance: 0");
    }

    private void assertPrinted(String... expectedLogs) {
        List<String> logs = Arrays.asList(outContent.toString().split("\r\n"));
        assertThat(logs).containsExactly(expectedLogs);
    }

}
