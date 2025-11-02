package lotto.util.factory;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.parser.NumberParser;
import lotto.util.validator.NumberValidator;

public class NumberFactory {

    private final NumberParser parser;

    public NumberFactory() {
        NumberValidator validator = new NumberValidator(Lotto.ONE_LOTTO_PRICE);
        this.parser = new NumberParser(validator);
    }

    public int money() throws IllegalArgumentException{
        String input = Console.readLine();
        return parser.intOf(input);
    }
}
