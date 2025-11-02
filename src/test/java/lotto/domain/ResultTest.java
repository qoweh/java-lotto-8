package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {
    private static Lottos lottos;
    private static final Lotto correctLotto = new Lotto(List.of(11, 12 ,13 ,14 ,15, 16));
    private static final int correctLottoBonusNumber = 17;

    @BeforeAll
    static void setUp() {
        LottosFactory factory = new LottosFactory();
        lottos = factory.of(1000, new LottoFactory());
    }

    @BeforeEach
    void clean() {
        lottos.getLottos().clear();
    }

    @Test
    void 당첨되지_않은_경우() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);
        lottos.getLottos().add(new Lotto(integers));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertResult(result, Rank.NONE);
    }

    @Test
    void 하나만_당첨된_경우() {
        // given
        List<Integer> integers = List.of(11, 12, 13, 4, 5, 6);
        lottos.getLottos().add(new Lotto(integers));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertResult(result, Rank.THREE);
    }

    private static void assertResult(Result result, Rank rank) {
        assertThat(result.getRanks().getFirst())
                .isEqualTo(rank);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(rank));
    }

    private static double calculateRate(Rank rank) {
        return (double) rank.getPrize() / (lottos.getLottos().size() * 1000);
    }

    @Test
    void 같은_등수로_여러개_당첨된_경우() {
        // given
        List<Integer> integers1 = List.of(11, 12, 13, 4, 5, 6);
        List<Integer> integers2 = List.of(11, 12, 13, 4, 5, 6);
        lottos.getLottos().add(new Lotto(integers1));
        lottos.getLottos().add(new Lotto(integers2));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertThat(result.getRanks())
                .containsExactly(Rank.THREE, Rank.THREE);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(Rank.THREE) * 2);
    }

    @Test
    void 다른_등수로_여러개_당첨된_경우() {
        // given
        List<Integer> integers1 = List.of(11, 12, 13, 4, 5, 6);
        List<Integer> integers2 = List.of(11, 12, 13, 14, 15, 6);
        lottos.getLottos().add(new Lotto(integers1));
        lottos.getLottos().add(new Lotto(integers2));

        // when
        Result result = Result
                .of(lottos, correctLotto, correctLottoBonusNumber);

        // then
        assertThat(result.getRanks())
                .containsExactly(Rank.FIVE, Rank.THREE);
        assertThat(result.getRate())
                .isEqualTo(calculateRate(Rank.THREE) + calculateRate(Rank.FIVE));
    }
}