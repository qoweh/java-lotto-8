package lotto.util.validator;

import lotto.util.ErrorMessage;

public class NumberValidator {
    public void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBER);
        }
    }
}
