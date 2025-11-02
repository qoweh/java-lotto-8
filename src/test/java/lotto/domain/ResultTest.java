package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private static final Lotto correctLotto = new Lotto(List.of(11, 12 ,13 ,14 ,15, 16));
    private static final int correctLottoBonusNumber = 17;

    @Test
    void 당첨되지_않은_경우() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertResult(result, lottos, Rank.NONE);
    }

    @Test
    void 하나만_당첨된_경우() {
        // given
        Lotto lotto = new Lotto(List.of(11, 12, 13, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertResult(result, lottos, Rank.THREE);
    }

    private static void assertResult(Result result, Lottos lottos, Rank rank) {
        assertThat(result.getRanks().getFirst())
                .isEqualTo(rank);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(rank, lottos));
    }

    private static double calculateRate(Rank rank, Lottos lottos) {
        return (double) rank.getPrize() / (lottos.getLottos().size() * Lotto.ONE_LOTTO_PRICE) * 100;
    }

    @Test
    void 같은_등수로_여러개_당첨된_경우() {
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 4, 5, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertThat(result.getRanks())
                .containsExactly(Rank.THREE, Rank.THREE);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(Rank.THREE, lottos) * 2);
    }

    @Test
    void 다른_등수로_여러개_당첨된_경우() {
        // given
        Lotto lotto1 = new Lotto(List.of(11, 12, 13, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(11, 12, 13, 14, 15, 6));
        Lottos lottos = new Lottos(List.of(lotto1, lotto2));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertThat(result.getRanks())
                .contains(Rank.FIVE, Rank.THREE);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(Rank.THREE, lottos) + calculateRate(Rank.FIVE, lottos));
    }
}