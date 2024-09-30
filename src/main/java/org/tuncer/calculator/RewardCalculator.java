package org.tuncer.calculator;

import org.tuncer.configFile.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class RewardCalculator {

   private final Map<Symbol, List<WinCombination>> winningCombinations;
   private final BonusSymbol[] bonusSymbols;
   private final double bettingAmount;

    public RewardCalculator(final Map<Symbol, List<WinCombination>> winningCombinations,
                            final BonusSymbol[] bonusSymbols,
                            final double bettingAmount) {
        this.winningCombinations = winningCombinations;
        this.bonusSymbols = bonusSymbols;
        this.bettingAmount = bettingAmount;
    }


    public double calculate() {

        AtomicReference<Double> reward = new AtomicReference<>((double) 0);

        winningCombinations.forEach((symbol,combinations) -> {

            AtomicReference<Double> symbolReward = new AtomicReference<>((double) 1);

            StandardSymbol standardSymbol = (StandardSymbol) symbol;
            double symbolRewardMultiplier = standardSymbol.getRewardMultiplier();

            symbolReward.set(bettingAmount * symbolRewardMultiplier);

            combinations.forEach(winCombination -> {
                double combinationRewardMultiplier = winCombination.getRewardMultiplier();
                symbolReward.set(combinationRewardMultiplier * symbolReward.get());
            });

            reward.updateAndGet(v -> (v + symbolReward.get()));

        });

        Arrays.stream(bonusSymbols)
                .filter(b -> b.getImpact().equals(SymbolImpact.multiply_reward))
                .map(b -> (MultiplierBonusSymbol)b)
                .forEach(b -> reward.set(b.getRewardMultiplier() * reward.get()));

        Arrays.stream(bonusSymbols)
                .filter(b -> b.getImpact().equals(SymbolImpact.extra_bonus))
                .map(b -> (ExtraBonusSymbol)b)
                .forEach(b -> reward.set(b.getExtra() + reward.get()));

        return reward.get();
    }
}
