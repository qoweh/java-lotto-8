package lotto.view;

import java.util.List;
import lotto.domain.Lottos;

public class OutputView {
    private static final String PURCHASE_FORMAT = "\n";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void error(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void purchase(int count, List<List<Integer>> numbersBundle) {
        System.out.println(PURCHASE_FORMAT+ count + PURCHASE_MESSAGE);
        numbersBundle.forEach(System.out::println);
    }
}
