package lotto.util.dto;

import lotto.domain.Lotto;

public record WinningLotto(Lotto correctLotto, int correctLottoBonusNumber) {
}
