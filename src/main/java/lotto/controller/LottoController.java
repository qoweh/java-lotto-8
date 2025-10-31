package lotto.controller;

import lotto.util.factory.NumberFactory;
import lotto.view.InputView;

public class LottoController {
    private final NumberFactory numberFactory;

    public LottoController(NumberFactory numberFactory) {
        this.numberFactory = numberFactory;
    }

    public void run() {
        int money = numberFactory.money();
    }
}
