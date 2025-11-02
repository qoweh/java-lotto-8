package lotto.util.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.util.validator.CorrectNumbersValidator;

public class CorrectNumbersParser {
    private static final String DELIMITER = ",";
    private final CorrectNumbersValidator validator;

    public CorrectNumbersParser(CorrectNumbersValidator validator) {
        this.validator = validator;
    }

    public List<Integer> collectionOf(String input) {
        validator.validate(input);
        Stream<String> splitedStrings = Arrays.stream(input.split(DELIMITER));
        return splitedStrings.map(Integer::parseInt).toList();
    }

}
