import exception.InvalidAmountValueException;

public class Amount {
    private double value;

    private Amount(double value) {
        if (value <= 0) {
            throw new InvalidAmountValueException();
        }
        this.value = value;
    }

    static Amount ofValue(double value) {
        return new Amount(value);
    }

    public double getValue() {
        return value;
    }

}
