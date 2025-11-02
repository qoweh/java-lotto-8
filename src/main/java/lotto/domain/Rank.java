package lotto.domain;

public enum Rank {
    NONE(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    FIVE_BONUS(30000000),
    SIX(2000000000);

    private final int prize;

    Rank(int prize) {
        this.prize = prize;
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
}