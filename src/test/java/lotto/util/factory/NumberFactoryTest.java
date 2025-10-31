package lotto.util.factory;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class NumberFactoryTest {
    NumberFactory numberFactory = new NumberFactory();

    @AfterEach
    void afterEach() {
        Console.close();
    }

    @Test
    void 유효한_문자열_입력받기() {
        // given
        String input = " \n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
    }

    @Test
    void 숫자_문자열_입력받기() {
        // given
        String input = "1000JJJJ\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
    }

    @Test
    void 음수는_양수로_입력받기() {
        // given
        String input = "-1000\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
    }
  
}