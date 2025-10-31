package lotto.util.factory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberFactoryTest {
    NumberFactory numberFactory = new NumberFactory();
    ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void beforeEach() {
        System.setOut(new PrintStream(output));
    }

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
        Assertions.assertThat(output.toString()).contains(ErrorMessage.WHITESPACE_STRING);
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
        Assertions.assertThat(output.toString()).contains(ErrorMessage.ONLY_NUMBER);
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
        Assertions.assertThat(output.toString()).contains(ErrorMessage.ONLY_POSITIVE_NUMBER);
    }

    @Test
    void 입력은_1000원_단위로_받기() {
        // given
        String input = "1200\n1000";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int money = numberFactory.money();

        // when
        Assertions.assertThat(money).isEqualTo(1000);
        Assertions.assertThat(output.toString()).contains(ErrorMessage.INVALID_NUMBER_VALUE);
    }
  
}