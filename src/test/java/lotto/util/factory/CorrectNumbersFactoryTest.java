package lotto.util.factory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.util.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CorrectNumbersFactoryTest {
    private static final String LF = "\n";
    private final CorrectNumbersFactory correctNumbersFactory = new CorrectNumbersFactory();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    private String IntegerstoString(List<Integer> input) {
        return input.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }

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
        String emptyString = "\n" + LF;
        String commaNumString = ",,,1,2,3,4,5,6,," + LF;
        String numString = "1,2,3,4,5,6";
        String input = emptyString + commaNumString + numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Lotto lotto = correctNumbersFactory.numbers();
        List<Integer> numbers = lotto.getNumbers();
        String lottoNumbers = IntegerstoString(numbers);

        // when
        Assertions.assertThat(lottoNumbers).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.WHITESPACE_STRING)
                .contains(ErrorMessage.INVALID_FORMAT);
    }

    @Test
    void 유효한_숫자_크기_입력받기() {
        // given
        String wrongNumString1 = "1,2,3,4,5,0" + LF;
        String wrongNumString2 = "1,2,3,4,5,110" + LF;
        String numString = "1,2,3,4,5,6";
        String input = wrongNumString1 + wrongNumString2 +numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Lotto lotto = correctNumbersFactory.numbers();
        List<Integer> numbers = lotto.getNumbers();
        String lottoNumbers = IntegerstoString(numbers);

        // when
        Assertions.assertThat(lottoNumbers).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    void 유효한_숫자_개수_입력받기() {
        // given
        String wrongNumString1 = "1,2,3,4," + LF;
        String wrongNumString2 = "1,2,3,4,5,6,7,8" + LF;
        String numString = "1,2,3,4,5,6";
        String input = wrongNumString1 + wrongNumString2 + numString;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Lotto lotto = correctNumbersFactory.numbers();
        List<Integer> numbers = lotto.getNumbers();
        String lottoNumbers = IntegerstoString(numbers);

        // when
        Assertions.assertThat(lottoNumbers).isEqualTo(numString);
        Assertions.assertThat(output.toString())
                .contains(ErrorMessage.NEED_6_NUMBERS);
    }
}