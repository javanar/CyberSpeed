package org.tuncer.scratch;

import org.tuncer.Output;
import org.tuncer.calculator.RewardCalculator;
import org.tuncer.calculator.finder.BonusSymbolFinder;
import org.tuncer.calculator.finder.CombinationFinder;
import org.tuncer.configFile.BonusSymbol;
import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.WinCombination;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultProcessor {

    private final Symbol[][] symbolMatrix;
    private final double bettingAmount;
    private final GameConfig gameConfig;

    public ResultProcessor(final Symbol[][] symbolMatrix,
                           final double bettingAmount,
                           final GameConfig gameConfig) {
        this.symbolMatrix = symbolMatrix;
        this.bettingAmount = bettingAmount;
        this.gameConfig = gameConfig;
    }

    public Output process() {

        CombinationFinder combinationFinder = new CombinationFinder(symbolMatrix, gameConfig);
        Map<Symbol, List<WinCombination>> winningCombinations = combinationFinder.getWinningCombinations();

        BonusSymbolFinder bonusSymbolFinder = new BonusSymbolFinder(symbolMatrix);
        BonusSymbol[] bonusSymbols = bonusSymbolFinder.getBonusSymbols();

        RewardCalculator rewardCalculator = new RewardCalculator(winningCombinations, bonusSymbols, bettingAmount);
        double reward = rewardCalculator.calculate();

        String[] oneDimensional = Arrays.stream(symbolMatrix)
                .flatMap(Arrays::stream)
                .map(Symbol::getExplanation)
                .toArray(String[]::new);

        String[][] stringMatrix = new String[symbolMatrix.length][symbolMatrix[0].length];

        for (int i = 0; i < symbolMatrix.length; i++) {
            System.arraycopy(oneDimensional, i * symbolMatrix.length, stringMatrix[i], 0, symbolMatrix[0].length);
        }

        OutputProcessor outputProcessor = new OutputProcessor(stringMatrix, reward, winningCombinations, bonusSymbols);
        return outputProcessor.process();


    }
}
