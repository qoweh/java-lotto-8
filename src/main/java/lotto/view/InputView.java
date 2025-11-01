package lotto.view;

public class InputView {
    private static final String MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String CORRECT_LOTTO_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String CORRECT_LOTTO_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    public static void money() {
        System.out.println(MONEY_MESSAGE);
    }

    public static void correctLottoNumbers() {
        System.out.println(CORRECT_LOTTO_NUMBERS_MESSAGE);
    }

    public static void correctLottoBonusNumber() {
        System.out.println(CORRECT_LOTTO_BONUS_NUMBER_MESSAGE);
    }
}
