package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.util.factory.CorrectNumbersFactory;
import lotto.util.factory.NumberFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberFactory numberFactory;
    private final CorrectNumbersFactory correctNumbersFactory;

    public LottoController(NumberFactory numbersFactory, CorrectNumbersFactory correctNumbersFactory) {
        this.numberFactory = numbersFactory;
        this.correctNumbersFactory = correctNumbersFactory;
    }

    public void run() {
        InputView.money();
        int money = numberFactory.money();

        LottoFactory factory = new LottoFactory();
        Lottos lottos = Lottos.of(money, factory);

        int purchaseLottos = lottos.getLottosCount();
        List<List<Integer>> purchasedLottosNumbers = lottos.getLottosNumbers();
        OutputView.purchase(purchaseLottos, purchasedLottosNumbers);

        InputView.correctLottoNumbers();
        Lotto correctLotto = correctNumbersFactory.numbers(); // 기능 구현 끝 - 커밋 정리하고 리팩토링 시작

        InputView.correctLottoBonusNumber();
//        int coreectLottoBonusNumber =

    }
}
