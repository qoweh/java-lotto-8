package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.view.OutputView;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int money, LottoFactory factory) {
        List<Lotto> lottos = new ArrayList<>();
        int count = money / 1000;

        makeLottos(factory, count, lottos);

        return new Lottos(List.copyOf(lottos));
    }

    private static void makeLottos(LottoFactory factory, int count, List<Lotto> lottos) {
        try {
            for (int i = 0; i < count; i++) {
                Lotto lotto = factory.lotto();
                lottos.add(lotto);
            }
        } catch (IllegalStateException e) {
            OutputView.error(e);
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosCount() {
        return lottos.size();
    }

    public List<List<Integer>> getLottosNumbers() {
        List<List<Integer>> lottosNumbers = new ArrayList<>();

        lottos.forEach(
                lotto -> {
                    lottosNumbers.add(lotto.getNumbers());
                }
        );

        return lottosNumbers;
    }
}
