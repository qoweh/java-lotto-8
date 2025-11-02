package lotto.domain;

import java.util.List;

public class Result {
    private final List<Rank> ranks;
    private final double rate;

    private Result(List<Rank> ranks, double rate) {
        this.ranks = ranks;
        this.rate = rate;
    }

    public static Result of(
            Lottos purchaseLottos,
            Lotto correctLotto,
            int correctLottoBonusNumber) {
        // rank : 몇 등인지
        // rate : 등수에 해당하는 금액 / lottos의 개수 * 1000원


        return new Result(null, 0);
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getRate() {
        return rate;
    }

}
