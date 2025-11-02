package lotto.util.validator;

import lotto.util.ErrorMessage;

public class NumberValidator {
    private final int price;
    private static final String REGEXP_PATTERN_NUMBER = "^-?\\d*$";

    public NumberValidator(int price) {
        this.price = price;
    }

    public void validate(String input) {
        validateNotBlank(input);
        validateNumberType(input);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }

    private void validateNumberType(String input) {
        if (!input.matches(REGEXP_PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
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
