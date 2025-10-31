package lotto.domain;

import java.util.List;
import lotto.util.validator.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NEED_6_NUMBERS);
        }
    }

    // TODO: 추가 기능 구현
}
