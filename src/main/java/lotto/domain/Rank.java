package lotto.domain;

import java.util.List;

public enum Rank {
    NONE(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int count;
    private final int prize;

    Rank(int count, int prize) {
        this.count = count;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank valueOf(long count, boolean isBonus) {
        if (count == 3) {
            return Rank.THREE;
        } else if (count == 4) {
            return Rank.FOUR;
        } else if (count == 5) {
            if (isBonus) {
                return Rank.FIVE_BONUS;
            }
            return Rank.FIVE;
        } else if (count == 6) {
            return Rank.SIX;
        }
        return Rank.NONE;
    }

    public static int countRank(List<Rank> ranks, Rank rank) {
        return (int) ranks
                .stream()
                .filter(eachRank -> eachRank.equals(rank))
                .count();
    }
}