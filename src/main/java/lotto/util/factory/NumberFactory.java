package lotto.util.factory;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.parser.NumberParser;
import lotto.util.validator.ErrorMessage;

public class NumberFactory {
    private final NumberParser numberParser;

    public NumberFactory() {
        this.numberParser = new NumberParser();
    }

    public int money() {
        while (true) {
            String input = Console.readLine();
            try {
                validate(input);
                return numberParser.intOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }
}
