package lotto.util.validator;

public class ErrorMessage {
    public static final String FORMAT = "[ERROR] ";
    public static final String NEED_6_NUMBERS = FORMAT + "로또 번호는 6개여야 합니다.";
    public static final String WHITESPACE_STRING = FORMAT + "빈 문자열입니다.";
    public static final String ONLY_NUMBER = FORMAT + "숫자만 입력받습니다.";
    public static final String ONLY_POSITIVE_NUMBER = FORMAT + "양수만 입력받습니다.";
}
