package lotto.util;

public class ErrorMessage {
    public static final String FORMAT = "[ERROR] ";
    public static final String NEED_6_NUMBERS = FORMAT + "로또 번호는 6개여야 합니다.";
    public static final String WHITESPACE_STRING = FORMAT + "빈 문자열입니다.";
    public static final String ONLY_NUMBER = FORMAT + "숫자만 입력받습니다.";
    public static final String ONLY_POSITIVE_NUMBER = FORMAT + "양수만 입력받습니다.";
    public static final String INVALID_NUMBER_VALUE = FORMAT + "1000원 단위로 나눠져야 합니다";
    public static final String INVALID_LOTTO_NUMBER = FORMAT + "로또 번호가 범위를 넘었습니다.";
    public static final String SAME_LOTTO_NUMBER = FORMAT + "로또 번호 중 중복된 번호가 존재합니다.";
    public static final String INVALID_FORMAT = FORMAT + "유효한 형식이 아닙니다. (공백없이, 숫자 사이에 컴마가 존재하는 문자열)";
}
