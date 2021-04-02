package domain;

public enum WinningStatus {
    SIX_MATCH(6, false, 2000000000),
    FIVE_MATCH_WITH_BONUS_BALL(5, true, 30000000),
    FIVE_MATCH(5, false, 1500000),
    FOUR_MATCH(4, false, 50000),
    THREE_MATCH(3, false, 5000);

    private final int matchCount;
    private final int winningMoney;
    private final boolean BonusBall;

    WinningStatus(int matchCount, boolean BonusBall, int winningMoney){
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.BonusBall = BonusBall;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public boolean hasBonusBall() {
        return this.BonusBall;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }
}