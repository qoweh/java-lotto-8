package lotto.util.factory;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.ErrorMessage;
import lotto.util.parser.CorrectNumbersParser;
import lotto.view.OutputView;

public class CorrectNumbersFactory {
    private static final String REGEXP_PATTERN_STRING = "^(\\d+,)*\\d+$";
    private final CorrectNumbersParser parser;

    public CorrectNumbersFactory() {
        this.parser = new CorrectNumbersParser();
    }

    public Lotto numbers() {
        while (true) {
            String input = Console.readLine();
            try {
                validate(input);
                List<Integer> integers = parser.collectionOf(input);
                return new Lotto(integers);
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
        }
    }

    private void validate(String input) {
        validateNotBlank(input);
        validateStringType(input);
    }

    private static void validateNotBlank(String input) {
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
