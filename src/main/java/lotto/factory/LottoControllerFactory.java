package lotto.factory;

import lotto.controller.LottoController;

public class LottoControllerFactory {
    public LottoController lottoController() {
        return new LottoController();
    }
}
