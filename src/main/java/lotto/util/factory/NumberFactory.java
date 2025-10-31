package lotto.util.factory;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.parser.NumberParser;
import lotto.util.validator.ErrorMessage;

public class NumberFactory {
    private final NumberParser numberParser;
    private static final String MINUS = "-";
    private static final String REGEXP_PATTERN_NUMBER = "^-?[\\d]*$";

    public NumberFactory() {
        this.numberParser = new NumberParser();
    }

    public int money() {
        while (true) {
            String input = Console.readLine();
            try {
                validate(input);
                int number = Integer.parseInt(input);
                validate(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
        if (!input.matches(REGEXP_PATTERN_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_POSITIVE_NUMBER);
        }
    }

}
