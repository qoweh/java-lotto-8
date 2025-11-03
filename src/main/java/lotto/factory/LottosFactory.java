package lotto.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottosFactory {
    public static Lottos of(int money, LottoFactory factory) throws IllegalArgumentException {
        int count = money / Lotto.ONE_LOTTO_PRICE;
        List<Lotto> lottos = makeLottos(factory, count);
        return new Lottos(List.copyOf(lottos));
    }

    private static List<Lotto> makeLottos(LottoFactory factory, int count) throws IllegalArgumentException {
        List<Lotto> lottos = new ArrayList<>();
        for (int index = 0; index < count; index++) {
            Lotto lotto = factory.lotto();
            lottos.add(lotto);
        }
        return lottos;
    }
}
