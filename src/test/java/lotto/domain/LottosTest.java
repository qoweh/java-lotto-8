package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottosTest {

    LottosFactory factory = new LottosFactory();

    @Test
    void 로또를_구매금액만큼_만든다() {
        // given
        int count = 10000;
        int money = 1000;

        // when
        Lottos lottos = factory.of(count * money, new LottoFactory());

        // then
        Assertions.assertThat(lottos.getLottos().size()).isEqualTo(count);
    }

  
}