package lotto.domain;

import java.util.FormatFlagsConversionMismatchException;
import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NEED_6_NUMBERS);
        }
        for (int i = 0; i < numbers.size(); i++) {
            if (isOutrange(numbers.get(i))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
            }
            if (i >= 1 && isDuplicate(numbers, i)) {
                throw new IllegalArgumentException(ErrorMessage.SAME_LOTTO_NUMBER);
            }
        }

    }

    private boolean isOutrange(int number) {
        return !(1 <= number && number <= 45);
    }

    private boolean isDuplicate(List<Integer> numbers, int index) {
        return numbers.get(index).equals(numbers.get(index - 1));
    }

}
