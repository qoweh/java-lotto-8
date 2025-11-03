package lotto.domain;

import java.util.List;
import lotto.util.ErrorMessage;

public class Lotto {
    public static final int ONE_LOTTO_PRICE  = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NEED_6_NUMBERS);
        }
        for (int index = 0; index < numbers.size(); index++) {
            if (isOutrange(numbers.get(index))) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER);
            }
            if (index >= 1 && isDuplicate(numbers, index)) {
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

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
