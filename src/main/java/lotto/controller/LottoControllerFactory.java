package lotto.controller;

import lotto.util.factory.NumberFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoControllerFactory {
    public LottoController lottoController() {
        NumberFactory numberFactory = new NumberFactory();

        return new LottoController(numberFactory);
    }
}
