package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottosFactory {
    public Lottos of(int money, LottoFactory factory) throws IllegalArgumentException {
        List<Lotto> lottos = new ArrayList<>();
        int count = money / 1000;

        makeLottos(factory, count, lottos);

        return new Lottos(List.copyOf(lottos));
    }

    private void makeLottos(LottoFactory factory, int count, List<Lotto> lottos) {
        for (int i = 0; i < count; i++) {
            Lotto lotto = factory.lotto();
            lottos.add(lotto);
        }
    }
}
