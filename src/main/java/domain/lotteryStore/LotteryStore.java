package domain.lotteryStore;

import java.util.ArrayList;
import java.util.List;

import domain.value.ManualNumbersGenerator;

public class LotteryStore {
    private final AutoNumbersGenerator autoNumbersGenerator = new AutoNumbersGenerator();

    public Lotteries createLotteries(int purchasedCount, int manualCount, List<String> manualNumbers) {
        List<Lottery> lotteries = new ArrayList<>();
        List<Lottery> manualLotteries = makeManualLotteries(manualCount, manualNumbers);
        List<Lottery> autoLotteries = makeAutoLotteries(purchasedCount, manualCount);

        lotteries.addAll(manualLotteries);
        lotteries.addAll(autoLotteries);

        return new Lotteries(lotteries);
    }

    private List<Lottery> makeManualLotteries(int manualCount, List<String> manualNumbers) {
        List<Lottery> manualLotteries = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Numbers numbers = new Numbers(new ManualNumbersGenerator(manualNumbers.get(i)).getManualNumbers());
            manualLotteries.add(new Lottery(numbers));
        }
        return manualLotteries;
    }

    private List<Lottery> makeAutoLotteries(int purchasedCount, int manualCount) {
        List<Lottery> autoLotteries = new ArrayList<>();
        int autoCount = purchasedCount - manualCount;
        while (autoCount-- > 0) {
            autoLotteries.add(makeAutoLottery());
        }
        return autoLotteries;
    }

    private Lottery makeAutoLottery() {
        autoNumbersGenerator.shuffle();
        Numbers numbers = new Numbers(autoNumbersGenerator.getSixNumbersFromTheFront());
        return new Lottery(numbers);
    }
}
