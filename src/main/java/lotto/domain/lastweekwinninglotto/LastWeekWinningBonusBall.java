package lotto.domain.lastweekwinninglotto;

public class LastWeekWinningBonusBall {

    private final int bonusBall;
    public LastWeekWinningBonusBall(int bonusBall){
        int df = validate(bonusBall);
        this.bonusBall = bonusBall;
    }

    public int getLastWeekWinningBonusBall(){
        return this.bonusBall;
    }
}
