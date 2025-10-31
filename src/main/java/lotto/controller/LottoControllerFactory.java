package lotto.controller;

import lotto.util.factory.CorrectNumbersFactory;
import lotto.util.factory.NumberFactory;

public class LottoControllerFactory {
    public LottoController lottoController() {
        NumberFactory numberFactory = new NumberFactory();
        CorrectNumbersFactory correctNumbersFactory = new CorrectNumbersFactory();

        return new LottoController(numberFactory, correctNumbersFactory);
    }
}
