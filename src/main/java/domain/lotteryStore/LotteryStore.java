package domain.lotteryStore;

import java.util.ArrayList;
import java.util.List;

import domain.lotteryStore.numbers.AutoNumbersGenerator;
import domain.lotteryStore.numbers.Lottery;
import domain.lotteryStore.numbers.ManualNumbersGenerator;

public class LotteryStore {
    public static Lotteries createLotteries(int purchasedCount, int manualCount, List<String> manualNumbers) {
        List<Lottery> lotteries = new ArrayList<>();
        List<Lottery> manualLotteries = makeManualLotteries(manualCount, manualNumbers);
        List<Lottery> autoLotteries = makeAutoLotteries(purchasedCount, manualCount);

        lotteries.addAll(manualLotteries);
        lotteries.addAll(autoLotteries);

        return new Lotteries(lotteries);
    }

    private static List<Lottery> makeManualLotteries(int manualCount, List<String> manualNumbers) {
        List<Lottery> manualLotteries = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Lottery lottery = new Lottery(new ManualNumbersGenerator(manualNumbers.get(i)).getManualNumbers());
            manualLotteries.add(lottery);
        }
        return manualLotteries;
    }

    private static List<Lottery> makeAutoLotteries(int purchasedCount, int manualCount) {
        List<Lottery> autoLotteries = new ArrayList<>();
        int autoCount = purchasedCount - manualCount;
        while (autoCount-- > 0) {
            Lottery lottery = new Lottery(AutoNumbersGenerator.getSixNumbersFromTheFront());
            autoLotteries.add(lottery);
        }
        return autoLotteries;
    }
}
