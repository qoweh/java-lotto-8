package lotto.util.validator;

import lotto.util.ErrorMessage;

public class CorrectNumbersValidator {
    private static final String REGEXP_PATTERN_STRING = "^(\\d+,)*\\d+$";

    public void validate(String input) {
        validateNotBlank(input);
        validateStringType(input);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }

    private void validateStringType(String input) {
        if (!input.matches(REGEXP_PATTERN_STRING)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT);
        }
    }
}
