package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.LottosFactory;
import lotto.util.factory.CorrectLottoFactory;
import lotto.util.factory.NumberFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final NumberFactory numberFactory;
    private final CorrectLottoFactory correctLottoFactory;

    public LottoController(NumberFactory numbersFactory, CorrectLottoFactory correctLottoFactory) {
        this.numberFactory = numbersFactory;
        this.correctLottoFactory = correctLottoFactory;
    }

    public void run() {
        int money = payMoney();
        Lottos lottos = purchaseLottos(money);
        printPurchaseLottos(lottos);

        Lotto correctLotto = makeCorrectLotto();
        int correctLottoBonusNumber = makeCorrectLottoBonusNumber();


    }

    private int payMoney() {
        InputView.money();

        while (true) {
            try {
                return numberFactory.money();
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
        }
    }

    private Lottos purchaseLottos(int money) {
        while (true) {
            try {
                LottoFactory lottoFactory = new LottoFactory();
                LottosFactory lottosFactory = new LottosFactory();

                return lottosFactory.of(money, lottoFactory);
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
        }
    }

    private void printPurchaseLottos(Lottos lottos) {
        int purchaseLottos = lottos.getLottosCount();
        List<List<Integer>> purchasedLottosNumbers = lottos.getLottosNumbers();

        OutputView.purchase(purchaseLottos, purchasedLottosNumbers);
    }

    private Lotto makeCorrectLotto() {
        InputView.correctLottoNumbers();

        while (true) {
            try {
                return correctLottoFactory.numbers();
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
        }
    }

    private int makeCorrectLottoBonusNumber(Lotto correctLotto) {
        CorrectLottoBonusNumberFactory factory = new CorrectLottoBonusNumberFactory();
        InputView.correctLottoBonusNumber();

        while (true) {
            try {
                return factory.bonusNumber(correctLotto);
            } catch (IllegalArgumentException e) {
                OutputView.error(e);
            }
            }
    }
}
