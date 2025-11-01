package lotto.controller;

import lotto.util.factory.CorrectLottoFactory;
import lotto.util.factory.NumberFactory;

public class LottoControllerFactory {
    public LottoController lottoController() {
        NumberFactory numberFactory = new NumberFactory();
        CorrectLottoFactory correctNumbersFactory = new CorrectLottoFactory();

        return new LottoController(numberFactory, correctNumbersFactory);
    }
}
