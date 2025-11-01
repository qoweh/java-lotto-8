package lotto.controller;

import lotto.util.factory.CorrectLottoFactory;
import lotto.util.factory.NumberFactory;

public class LottoControllerFactory {
    public LottoController lottoController() {
        return new LottoController();
    }
}
