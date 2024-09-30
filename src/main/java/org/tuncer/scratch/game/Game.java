package org.tuncer.scratch.game;

import org.tuncer.scratch.calculator.MatrixAnalyzer;
import org.tuncer.scratch.calculator.RewardCalculator;
import org.tuncer.scratch.calculator.finder.BonusSymbolFinder;
import org.tuncer.scratch.calculator.finder.WinCombinationFinder;
import org.tuncer.scratch.config.BonusSymbol;
import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.WinCombination;
import org.tuncer.scratch.matrix.MatrixCreator;
import org.tuncer.scratch.output.Output;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Game {

    private final GameConfig gameConfig;

    public Game(final GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    public Output play(double bettingAmount) throws IOException {
        Symbol[][] symbolMatrix =  new MatrixCreator(gameConfig).create();

        MatrixAnalyzer matrixAnalyzer = new MatrixAnalyzer(
                new WinCombinationFinder(symbolMatrix, gameConfig), new BonusSymbolFinder(symbolMatrix));
        Map<Symbol, List<WinCombination>> winningCombinations = matrixAnalyzer.getWinningCombinations();
        BonusSymbol[] bonusSymbols = matrixAnalyzer.getBonusSymbols();

        double reward = new RewardCalculator(winningCombinations, bonusSymbols, bettingAmount).calculate();

        String[][] stringMatrix = convertToStringMatrix(symbolMatrix);

        Output output = new Output();
        output.setMatrix(stringMatrix);
        output.setReward(reward);
        output.setAppliedBonusSymbols(bonusSymbols);
        output.setAppliedWinningCombinations(winningCombinations);

        return output;
    }

    private String[][] convertToStringMatrix(Symbol[][] symbolMatrix) {
        String[] symbolExplanations = Arrays.stream(symbolMatrix)
                .flatMap(Arrays::stream)
                .map(Symbol::getExplanation)
                .toArray(String[]::new);

        String[][] stringMatrix = new String[symbolMatrix.length][symbolMatrix[0].length];

        for (int i = 0; i < symbolMatrix.length; i++) {
            System.arraycopy(symbolExplanations, i * symbolMatrix.length, stringMatrix[i], 0, symbolMatrix[0].length);
        }

        return stringMatrix;
    }


}
