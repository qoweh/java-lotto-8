package lotto.util.parser;

import lotto.util.validator.NumberValidator;

public class NumberParser {
    private final NumberValidator validator;

    public NumberParser(NumberValidator validator) {
        this.validator = validator;
    }

    public int intOf(String input) {
        int number = Integer.parseInt(input);
        validator.validate(number);
        return number;
    }
}
