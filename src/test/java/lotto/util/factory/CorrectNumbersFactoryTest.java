package lotto.util.factory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CorrectNumbersFactoryTest {
    CorrectNumbersFactory correctNumbersFactory = new CorrectNumbersFactory();
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
        String emptyString = "\n";
        String commaNumString = ",,,1,2,3,4,5,6,,";
        String numString = "1,2,3,4,5,6";
        String input = emptyString + commaNumString + numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<Integer> numbers = correctNumbersFactory.numbers();

        // when
        Assertions.assertThat(numbers.toString()).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.WHITESPACE_STRING)
                .contains(ErrorMessage.INVALID_FORMAT);
    }

    @Test
    void 유효한_숫자_크기_입력받기() {
        // given
        String wrongNumString1 = "1,2,3,4,5,0";
        String wrongNumString2 = "1,2,3,4,5,110";
        String numString = "1,2,3,4,5,6";
        String input = " \n\n" + wrongNumString1 + wrongNumString2 +numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<Integer> numbers = correctNumbersFactory.numbers();

        // when
        Assertions.assertThat(numbers.toString()).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    void 유효한_숫자_개수_입력받기() {
        // given
        String wrongNumString1 = "1,2,3,4,";
        String wrongNumString2 = "1,2,3,4,5,6,7,8";
        String numString = "1,2,3,4,5,6";
        String input = wrongNumString1 + wrongNumString2 + numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        List<Integer> numbers = correctNumbersFactory.numbers();

        // when
        Assertions.assertThat(numbers.toString()).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.NEED_6_NUMBERS);
    }
}