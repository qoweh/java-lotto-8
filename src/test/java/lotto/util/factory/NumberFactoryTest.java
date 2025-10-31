package lotto.util.factory;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberFactoryTest {
    NumberFactory numberFactory = new NumberFactory();

    @Test
    void 입력값_정수_반환() {
        // given
        String input = " \n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
    }

    @Test
    void 두_번_입력하고_정수_반환() {
        // given
        String input = "1000J\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
    }
  
}