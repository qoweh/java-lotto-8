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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CorrectLottoBonusNumberFactoryTest {
    private final CorrectLottoBonusNumberFactory correctLottoBonusNumberFactory = new CorrectLottoBonusNumberFactory();
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final Lotto correctLotto = new Lotto(List.of(1,2,3,4,5,6));

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
        String input = "12";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        int bonusNumber = correctLottoBonusNumberFactory.bonusNumber(correctLotto);

        // when
        Assertions.assertThat(bonusNumber).isEqualTo(12);
    }

    @Test
    void 음수_입력받기() {
        // given
        String input = "-10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(() -> {
            correctLottoBonusNumberFactory.bonusNumber(correctLotto);
        })

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_POSITIVE_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "120"})
    void 범위를_벗어나는_값_입력받기(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when
        assertThatThrownBy(() -> {
            correctLottoBonusNumberFactory.bonusNumber(correctLotto);
        })

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER);
    }


    @ParameterizedTest
    @ValueSource(strings = {"14J", " 20"})
    void 다른_문자가_포함된_문자열_입력받기(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        /// when
        assertThatThrownBy(() -> {
            correctLottoBonusNumberFactory.bonusNumber(correctLotto);
        })

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 당첨로또_번호와_중복되는_번호_입력받기(String input) {
        // given
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        /// when
        assertThatThrownBy(() -> {
            correctLottoBonusNumberFactory.bonusNumber(correctLotto);
        })

        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.SAME_LOTTO_NUMBER);
    }
}