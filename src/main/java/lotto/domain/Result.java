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
            int bonusNumber) {
        List<Lotto> lottos = purchaseLottos.getLottos();
        List<Integer> correctLottoNumbers = correctLotto.getNumbers();

        List<Rank> ranks = makeRanks(lottos, correctLottoNumbers, bonusNumber);
        double rate = makeRate(lottos.size(), ranks);

        return new Result(ranks, rate);
    }

    private static List<Rank> makeRanks(List<Lotto> lottos, List<Integer> correctNumbers, int bonusNumber) {
        return lottos
                .stream()
                .map(lotto -> {
                    List<Integer> lottoNumbers = lotto.getNumbers();

                    long count = lottoNumbers
                            .stream()
                            .filter(correctNumbers::contains)
                            .count();

                    boolean isBonus = lottoNumbers.contains(bonusNumber);

                    return Rank.valueOf(count, isBonus);})
                .toList();
    }

    private static double makeRate(int size, List<Rank> ranks) {
        int purchasedMoney = size * Lotto.ONE_LOTTO_PRICE;
        int lottoPrice = ranks
                .stream()
                .map(Rank::getPrize)
                .mapToInt(Integer::intValue)
                .sum();
        return (double) lottoPrice / purchasedMoney * 100;
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public double getRate() {
        return rate;
    }

}
