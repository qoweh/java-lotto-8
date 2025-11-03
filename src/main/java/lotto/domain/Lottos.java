package lotto.domain;

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
        return lottos
                .stream()
                .map(Lotto::getNumbers)
                .toList();
    }
}
