package lotto.util.factory;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.ErrorMessage;
import lotto.util.parser.CorrectNumbersParser;

public class CorrectLottoFactory {
    private static final String REGEXP_PATTERN_STRING = "^(\\d+,)*\\d+$";
    private final CorrectNumbersParser parser;

    public CorrectLottoFactory() {
        this.parser = new CorrectNumbersParser();
    }

    public Lotto numbers() throws IllegalArgumentException{
        String input = Console.readLine();
        validate(input);
        return makeCorrectLotto(input);
    }

    private void validate(String input) {
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

    private Lotto makeCorrectLotto(String input) {
        List<Integer> integers = parser.collectionOf(input);
        return new Lotto(integers);
    }
}
