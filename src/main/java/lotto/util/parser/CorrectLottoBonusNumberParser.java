package lotto.util.parser;

import lotto.domain.Lotto;
import lotto.util.validator.CorrectLottoBonusNumberValidator;

public class CorrectLottoBonusNumberParser {
    private final CorrectLottoBonusNumberValidator validator;

    public CorrectLottoBonusNumberParser() {
        this.validator = new CorrectLottoBonusNumberValidator();
    }

    public int intOf(String input, Lotto correctLotto) {
        validator.validate(input);

        int number = Integer.parseInt(input);
        validator.validate(number, correctLotto);

        return number;
    }
}
