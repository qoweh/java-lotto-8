package lotto.util.factory;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.parser.CorrectLottoBonusNumberParser;

public class CorrectLottoBonusNumberFactory {
    private final CorrectLottoBonusNumberParser parser;

    public CorrectLottoBonusNumberFactory() {
        this.parser = new CorrectLottoBonusNumberParser();
    }

    public int bonusNumber(Lotto correctLotto) throws IllegalArgumentException {
        String input = Console.readLine();
        return parser.intOf(input);
    }
}
