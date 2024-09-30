package org.tuncer.scratch.output;

import org.tuncer.scratch.config.BonusSymbol;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.WinCombination;

import java.util.List;
import java.util.Map;

public class Output {

    private String[][] matrix;
    private double reward;
    private Map<Symbol, List<WinCombination>> appliedWinningCombinations;
    private BonusSymbol[] appliedBonusSymbols;

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public Map<Symbol, List<WinCombination>> getAppliedWinningCombinations() {
        return appliedWinningCombinations;
    }

    public void setAppliedWinningCombinations(Map<Symbol, List<WinCombination>> appliedWinningCombinations) {
        this.appliedWinningCombinations = appliedWinningCombinations;
    }

    public BonusSymbol[] getAppliedBonusSymbols() {
        return appliedBonusSymbols;
    }

    public void setAppliedBonusSymbols(BonusSymbol[] appliedBonusSymbols) {
        this.appliedBonusSymbols = appliedBonusSymbols;
    }

}
