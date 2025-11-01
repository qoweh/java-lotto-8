package lotto.domain;

public class CorrectLotto {
    private final int bonusNumber;
    private final Lotto lotto;

    public CorrectLotto(int bonusNumber, Lotto lotto) {
        this.bonusNumber = bonusNumber;
        this.lotto = lotto;
    }
}
