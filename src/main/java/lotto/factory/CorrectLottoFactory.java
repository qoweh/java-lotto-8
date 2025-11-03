package lotto.factory;

import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.parser.CorrectNumbersParser;
import lotto.util.validator.CorrectNumbersValidator;

public class CorrectLottoFactory {
    private final CorrectNumbersParser parser;

    public CorrectLottoFactory() {
        CorrectNumbersValidator validator = new CorrectNumbersValidator();
        this.parser = new CorrectNumbersParser(validator);
    }

    public Lotto numbers() throws IllegalArgumentException{
        String input = Console.readLine();
        return makeCorrectLotto(input);
    }

    private Lotto makeCorrectLotto(String input) throws IllegalArgumentException {
        List<Integer> integers = parser.collectionOf(input);
        return new Lotto(List.copyOf(integers));
    }
}
