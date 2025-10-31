package lotto.util.validator;

import lotto.util.ErrorMessage;

public class NumberValidator {
    private final int price;

    public NumberValidator(int price) {
        this.price = price;
    }

    public void validate(int number) {
        validatePositive(number);
        validateValidValue(number);
    }

    private void validateValidValue(int number) {
        if (number % price != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_VALUE);
        }
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBER);
        }
    }
}
