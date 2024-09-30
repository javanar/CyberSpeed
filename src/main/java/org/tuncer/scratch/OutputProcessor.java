package org.tuncer.scratch;

import org.tuncer.Output;
import org.tuncer.configFile.BonusSymbol;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.WinCombination;

import java.util.List;
import java.util.Map;

public class OutputProcessor {

    private final String[][] matrix;
    private final double reward;
    private final Map<Symbol, List<WinCombination>> winningCombinations;
    private final BonusSymbol[] bonusSymbols;

    public OutputProcessor(final String[][] matrix,
                           final double reward,
                           final Map<Symbol, List<WinCombination>> winningCombinations,
                           final BonusSymbol[] bonusSymbols) {
        this.matrix = matrix;
        this.reward = reward;
        this.winningCombinations = winningCombinations;
        this.bonusSymbols = bonusSymbols;
    }

    public Output process() {

        Output output = new Output();
        output.setMatrix(matrix);
        output.setReward(reward);
        output.setAppliedBonusSymbols(bonusSymbols);
        output.setAppliedWinningCombinations(winningCombinations);

        return output;
    }
}
