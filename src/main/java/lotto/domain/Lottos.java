package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
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
