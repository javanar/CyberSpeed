package org.tuncer;

import org.tuncer.configFile.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

    @Override
    public String toString() {

        String bonusString = "\""+ String.join("\",\"", Arrays.stream(appliedBonusSymbols).map(Symbol::getExplanation).toArray(String[]::new)) + "\"";

        StringBuilder combinationStringBuilder = new StringBuilder();
        AtomicInteger index = new AtomicInteger();
        appliedWinningCombinations.forEach((k,v) -> {
            index.getAndIncrement();
            combinationStringBuilder.append("\t\t\"").append(k.getExplanation()).append("\": [\"");

            String[] combinations = v.stream()
                    .map(w -> {
                        String s = w.getGroup().getGroup();
                        if(w.getGroup().equals(WinCombinationGroup.same_symbols)){
                            CountWinCombination cw = (CountWinCombination) w;
                            s += "_"+ cw.getCount() + "_times";
                        }
                        return s;
                    })
                    .toArray(String[]::new);
            String combinationsString = String.join("\",\"", combinations);

            combinationStringBuilder.append(combinationsString);
            combinationStringBuilder.append("\"]");
            if (index.get() != appliedWinningCombinations.size()) {
                combinationStringBuilder.append(",");
            }
            combinationStringBuilder.append("\n");
        });

        StringBuilder matrixStringBuilder = new StringBuilder();
        Arrays.stream(matrix).forEach(a-> {
            matrixStringBuilder.append("\t\t\"");
            String matrixString = String.join("\",\"", a);
            matrixStringBuilder.append(matrixString);
            matrixStringBuilder.append("\",\n");
        });

        if (matrixStringBuilder.length() > 0) {
            matrixStringBuilder.setLength(matrixStringBuilder.length() - 2);
        }

        return "{\n"
                +"\t\"matrix\":[\n"
                + matrixStringBuilder
                +"\n\t],\n"
                +"\t\"reward\": " + reward +",\n"
                +"\t\"applied_winning_combinations\": {\n"
                + combinationStringBuilder
                +"\t},\n"
                +"\t\"applied_bonus_symbols\":" + bonusString
                +"\n"
                +"}";
    }
}
