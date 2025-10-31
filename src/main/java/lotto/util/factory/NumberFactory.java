package lotto.util.factory;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessage;
import lotto.util.parser.NumberParser;
import lotto.util.validator.NumberValidator;
import lotto.view.OutputView;

public class NumberFactory {
    private static final String REGEXP_PATTERN_NUMBER = "^-?[\\d]*$";
    private static final int ONE_LOTTO_PRICE  = 1000;
    private final NumberParser parser;

    public NumberFactory() {
        NumberValidator validator = new NumberValidator(ONE_LOTTO_PRICE);
        this.parser = new NumberParser(validator);
    }

    public int money() {
        while (true) {
            String input = Console.readLine();
            try {
                validate(input);
                return parser.intOf(input);
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
        }
    }

    private void validate(String input) {
        validateNotBlank(input);
        validateNumberType(input);
    }

    private static void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }

    private static void validateNumberType(String input) {
        if (!input.matches(REGEXP_PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
    }
}
