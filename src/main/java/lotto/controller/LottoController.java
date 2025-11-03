package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Lottos;
import lotto.domain.LottosFactory;
import lotto.domain.Rank;
import lotto.domain.Result;
import lotto.util.factory.CorrectLottoBonusNumberFactory;
import lotto.util.factory.CorrectLottoFactory;
import lotto.util.factory.NumberFactory;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void run() {
        int money = payMoney();
        Lottos lottos = purchaseLottos(money);
        printPurchaseLottos(lottos);

        Lotto correctLotto = makeCorrectLotto();
        int correctLottoBonusNumber = makeCorrectLottoBonusNumber(correctLotto);
        Result result = Result.of(lottos, correctLotto, correctLottoBonusNumber);

        printResult(result);
    }

    private int payMoney() {
        NumberFactory factory = new NumberFactory();
        InputView.money();

        while (true) {
            try {
                return factory.money();
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
        CorrectLottoFactory factory = new CorrectLottoFactory();
        InputView.correctLottoNumbers();

        while (true) {
            try {
                return factory.numbers();
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

    private void printResult(Result result) {
        OutputView.resultNotify();
        List<Rank> resultRanks = result.getRanks();
        double resultRate = result.getRate();

        List<Rank> existentAllRanks = Arrays
                .stream(Rank.values())
                .filter(rank -> rank != Rank.NONE)
                .toList();

        existentAllRanks.forEach(rank -> {
            int targetCount = rank.getCount();
            int prize = rank.getPrize();
            int resultCount = Rank.countRank(resultRanks, rank);
            OutputView.count(targetCount, prize, resultCount);
        });

        OutputView.rate(resultRate);
    }
}
