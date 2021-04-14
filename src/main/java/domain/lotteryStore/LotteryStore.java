package domain.lotteryStore;

import java.util.ArrayList;
import java.util.List;

import domain.lotteryStore.numbers.AutoNumbersGenerator;
import domain.lotteryStore.numbers.ManualNumbersGenerator;
import domain.lotteryStore.numbers.Numbers;

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
            Numbers numbers = new Numbers(new ManualNumbersGenerator(manualNumbers.get(i)).getManualNumbers());
            manualLotteries.add(new Lottery(numbers));
        }
        return manualLotteries;
    }

    private static List<Lottery> makeAutoLotteries(int purchasedCount, int manualCount) {
        AutoNumbersGenerator autoNumbersGenerator = new AutoNumbersGenerator();
        List<Lottery> autoLotteries = new ArrayList<>();
        int autoCount = purchasedCount - manualCount;
        while (autoCount-- > 0) {
            autoLotteries.add(makeAutoLottery(autoNumbersGenerator));
        }
        return autoLotteries;
    }

    private static Lottery makeAutoLottery(AutoNumbersGenerator autoNumbersGenerator) {
        autoNumbersGenerator.shuffle();
        Numbers numbers = new Numbers(autoNumbersGenerator.getSixNumbersFromTheFront());
        return new Lottery(numbers);
    }
}
