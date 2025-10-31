package lotto.util.parser;

import lotto.util.validator.NumberValidator;

public class NumberParser {
    private final NumberValidator numberValidator;

    public NumberParser() {
        this.numberValidator = new NumberValidator();
    }

    public int intOf(String input) {
        int number = Integer.parseInt(input);
        numberValidator.validate(number);
        return number;
    }
}
