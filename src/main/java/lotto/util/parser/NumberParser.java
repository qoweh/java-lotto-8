package lotto.util.parser;

import lotto.util.validator.ErrorMessage;
import net.bytebuddy.jar.asm.TypeReference;

public class NumberParser implements Parser{
    @Override
    public int intOf(String input) throws IllegalArgumentException {
        int number = 0;

        try {
            number = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            number = intOf(input);
        }
        return number;
    }

    private void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.WHITESPACE_STRING);
        }
    }
}
