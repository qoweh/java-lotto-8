package lotto.view;

import java.text.NumberFormat;
import java.util.List;

public class OutputView {
    private static final String PURCHASE_MESSAGE_PREFIX = "\n";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_NOTIFY_MESSAGE = "\n당첨 통계\n---";
    private static final String RESULT_COUNT_MESSAGE_PREFIX = "개 일치 (";
    private static final String RESULT_COUNT_MESSAGE_MIDDLE = "원) - ";
    private static final String RESULT_COUNT_MESSAGE_SUFFIX = "개";
    private static final String RESULT_RATE_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String RESULT_RATE_MESSAGE_SUFFIX = "%입니다.";
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance();
    private static boolean second = false;

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
        String targetCountMessage = RESULT_COUNT_MESSAGE_PREFIX;
        if (targetCount == 5 && second) {
            targetCountMessage = "개 일치, 보너스 볼 일치 (";
            second = false;
        }

        System.out.println(
                targetCount + targetCountMessage
                + NUMBER_FORMAT.format(prize) + RESULT_COUNT_MESSAGE_MIDDLE
                + resultCount + RESULT_COUNT_MESSAGE_SUFFIX);

        if (targetCount == 5) {
            second = true;
        }
    }

    public static void rate(double rate) {
        System.out.println(RESULT_RATE_MESSAGE_PREFIX + rate + RESULT_RATE_MESSAGE_SUFFIX);
    }
}
