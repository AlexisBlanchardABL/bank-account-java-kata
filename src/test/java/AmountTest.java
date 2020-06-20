import exception.InvalidAmountValueException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AmountTest {

    @Test
    void given_negative_value_when_instantiating_an_amount_then_throws_an_exception() {
        // Given
        double negativeValue = -5;

        // When
        // Then
        IllegalArgumentException exception = assertThrows(InvalidAmountValueException.class, () -> Amount.ofValue(negativeValue));
        assertThat(exception.getMessage()).isEqualTo("Do not accept <= 0 values");
    }

    @Test
    void given_value_zero_when_instantiating_an_amount_then_throws_an_exception() {
        // Given
        double zero = 0;

        // When
        // Then
        IllegalArgumentException exception = assertThrows(InvalidAmountValueException.class, () -> Amount.ofValue(zero));
        assertThat(exception.getMessage()).isEqualTo("Do not accept <= 0 values");
    }

    @Test
    void given_happy_path_when_instantiating_an_amount_then_initiate_its_value() {
        // Given
        double validAmount = 10;

        // When
        Amount amount = Amount.ofValue(validAmount);

        // Then
        assertThat(amount.getValue()).isEqualTo(validAmount);
    }

}
