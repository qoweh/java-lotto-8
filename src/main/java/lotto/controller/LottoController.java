package lotto.controller;

import java.util.List;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.util.factory.NumberFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberFactory numberFactory;

    public LottoController(NumberFactory numberFactory) {
        this.numberFactory = numberFactory;
    }

    public void run() {
        InputView.money();
        int money = numberFactory.money();

        LottoFactory factory = new LottoFactory();
        Lottos lottos = Lottos.of(money, factory);

        int purchaseLottos = lottos.getLottosCount();
        List<List<Integer>> purchasedLottosNumbers = lottos.getLottosNumbers();
        OutputView.purchase(purchaseLottos, purchasedLottosNumbers);

    }
}
