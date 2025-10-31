package lotto.util.parser;

import java.util.List;

public class CorrectNumbersParser {
    private static final String DELIMITER = ",";

    public List<Integer> collectionOf(String input) {
        List<String> splitedStrings = List.of(input.split(DELIMITER));
        return splitedStrings.stream().map(Integer::parseInt).toList();
    }

}
