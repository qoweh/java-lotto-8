package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int money, LottoFactory factory) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money / 1000;

        try {
            for (int i = 0; i < count; i++) {
                Lotto lotto = factory.lotto();
                lottos.add(lotto);
            }
        } catch (IllegalStateException e) {
            OutputView.error(e);
        }
        return new Lottos(List.copyOf(lottos));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
