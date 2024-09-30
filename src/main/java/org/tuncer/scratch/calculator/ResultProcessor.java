package org.tuncer.scratch.calculator;

import org.tuncer.scratch.output.Output;
import org.tuncer.scratch.calculator.finder.BonusSymbolFinder;
import org.tuncer.scratch.calculator.finder.CombinationFinder;
import org.tuncer.scratch.config.BonusSymbol;
import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.WinCombination;

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

        Map<Symbol, List<WinCombination>> winningCombinations =
                new CombinationFinder(symbolMatrix, gameConfig).getWinningCombinations();

        BonusSymbol[] bonusSymbols = new BonusSymbolFinder(symbolMatrix).getBonusSymbols();

        double reward = new RewardCalculator(winningCombinations, bonusSymbols, bettingAmount).calculate();

        String[] symbolExplanations = Arrays.stream(symbolMatrix)
                .flatMap(Arrays::stream)
                .map(Symbol::getExplanation)
                .toArray(String[]::new);

        String[][] stringMatrix = new String[symbolMatrix.length][symbolMatrix[0].length];

        for (int i = 0; i < symbolMatrix.length; i++) {
            System.arraycopy(symbolExplanations, i * symbolMatrix.length, stringMatrix[i], 0, symbolMatrix[0].length);
        }

        Output output = new Output();
        output.setMatrix(stringMatrix);
        output.setReward(reward);
        output.setAppliedBonusSymbols(bonusSymbols);
        output.setAppliedWinningCombinations(winningCombinations);

        return output;

    }
}
