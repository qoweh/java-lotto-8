package lotto.util.validator;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.ErrorMessage;

public class CorrectLottoBonusNumberValidator {
    private static final String REGEXP_PATTERN_NUMBER = "^-?\\d*$";

    public void validate(String input) {
        validateNotBlank(input);
        validateNumberType(input);
    }

    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }

    private static void validateNumberType(String input) {
        if (!input.matches(REGEXP_PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
    }

    public void validate(int number, Lotto correctLotto) {
        validatePositive(number);
        validateValidValue(number);
        validateDuplicate(number, correctLotto);
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBER);
        }
    }

    private void validateValidValue(int number) {
        if (1 <= number && number <= 45) {
            return ;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    private void validateDuplicate(int number, Lotto correctLotto) {
        List<Integer> correctLottoNumbers = correctLotto.getNumbers();
        correctLottoNumbers.forEach((correctLottoNumber) -> {
            if (correctLottoNumber.equals(number)) {
                throw new IllegalArgumentException(ErrorMessage.SAME_LOTTO_NUMBER);
            }
        });
    }
}
