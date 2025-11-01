package lotto.domain;

import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoFactory {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public Lotto lotto() throws IllegalArgumentException {
        List<Integer> lottoNumbers = makeSortedNumbers();
        return new Lotto(List.copyOf(lottoNumbers));
    }

    private static List<Integer> makeSortedNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }

}
