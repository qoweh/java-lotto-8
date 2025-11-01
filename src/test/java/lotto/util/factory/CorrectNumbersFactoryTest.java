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
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CorrectNumbersFactoryTest {
    private final CorrectLottoFactory correctLottoFactory = new CorrectLottoFactory();
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
        String input = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        Lotto lotto = correctLottoFactory.numbers();
        List<Integer> numbers = lotto.getNumbers();
        String lottoNumbers = IntegerstoString(numbers);

        // when
        Assertions.assertThat(lottoNumbers).isEqualTo(input);
    }

    @Test
    void 크기가_작은_숫자_입력받기() {
        // given
        String input = "1,2,3,4,5,0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(correctLottoFactory::numbers)

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    void 크기가_큰_숫자_입력받기() {
        // given
        String input = "1,2,3,4,5,110";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(correctLottoFactory::numbers)

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER);
    }

    @Test
    void 적은_숫자_개수_입력받기() {
        // given
        String input = "1,2,3,4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(correctLottoFactory::numbers)

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEED_6_NUMBERS);
    }

    @Test
    void 많은_숫자_개수_입력받기() {
        // given
        String input = "1,2,3,4,5,6,7,8";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(correctLottoFactory::numbers)

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NEED_6_NUMBERS);
    }

    @Test
    void 유효하지_않은_문자열_입력받기() {
        // given
        String input  = ",,,1,2,3,4,5,6,,";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(correctLottoFactory::numbers)

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_FORMAT);
    }
}