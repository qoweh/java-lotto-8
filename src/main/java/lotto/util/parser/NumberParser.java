package lotto.util.parser;

import lotto.util.validator.NumberValidator;

public class NumberParser {
    private final NumberValidator numberValidator;

    public NumberParser(int value) {
        this.numberValidator = new NumberValidator(value);
    }

    public int intOf(String input) {
        int number = Integer.parseInt(input);
        numberValidator.validate(number);
        return number;
    }
}
