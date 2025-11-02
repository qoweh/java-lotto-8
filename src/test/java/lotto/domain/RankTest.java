package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    void ranks에서_rank개수_반환() {
        // given
        List<Rank> ranks = List.of(Rank.FOUR, Rank.FOUR, Rank.NONE);

        // when
        int count = Rank.countRank(ranks, Rank.FOUR);

        // then
        assertThat(count).isEqualTo(2);

    }

}