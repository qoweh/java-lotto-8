package lotto.view;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_MESSAGE_PREFIX = "\n";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_NOTIFY_MESSAGE = "\n당첨 통계\n---";
    private static final String RESULT_TARGET_COUNT_MESSAGE = "개 일치 (";
    private static final String RESULT_PRIZE_MESSAGE = "원) - ";
    private static final String RESULT_RESULT_COUNT_MESSAGE = "개";
    private static final String RESULT_RATE_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String RESULT_RATE_MESSAGE_SUFFIX = "%입니다.";
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
    private static int previousTargetCount;

    public static void error(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void purchase(int count, List<List<Integer>> numbersBundle) {
        System.out.println(PURCHASE_MESSAGE_PREFIX+ count + PURCHASE_MESSAGE);
        numbersBundle.forEach(System.out::println);
    }

    public static void resultNotify() {
        System.out.println(RESULT_NOTIFY_MESSAGE);
    }

    public static void count(int targetCount, int prize, int resultCount) {
        String resultTargetCountMessage = RESULT_TARGET_COUNT_MESSAGE;
        if (isSecondTargetCount(targetCount)) {
            resultTargetCountMessage = "개 일치, 보너스 볼 일치 (";
        }

        System.out.println(targetCount + resultTargetCountMessage
                + NUMBER_FORMAT.format(prize) + RESULT_PRIZE_MESSAGE
                + resultCount + RESULT_RESULT_COUNT_MESSAGE
        );

        previousTargetCount = targetCount;
    }

    private static boolean isSecondTargetCount(int targetCount) {
        return targetCount == previousTargetCount;
    }

    public static void rate(double rate) {
        System.out.println(RESULT_RATE_MESSAGE_PREFIX
                + String.format("%.1f", rate)
                + RESULT_RATE_MESSAGE_SUFFIX
        );
    }
}
