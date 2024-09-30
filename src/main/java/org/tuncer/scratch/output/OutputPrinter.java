package org.tuncer.scratch.output;

import org.tuncer.scratch.config.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OutputPrinter {

    private final Output output;

    public OutputPrinter(Output output) {
        this.output = output;
    }

    public String json() {


        BonusSymbol[] appliedBonusSymbols = output.getAppliedBonusSymbols();
        String bonusString = "\""+ String.join("\",\"", Arrays.stream(appliedBonusSymbols).map(Symbol::getExplanation).toArray(String[]::new)) + "\"";

        StringBuilder combinationStringBuilder = new StringBuilder();
        AtomicInteger index = new AtomicInteger();
        Map<Symbol, List<WinCombination>> appliedWinningCombinations = output.getAppliedWinningCombinations();
        appliedWinningCombinations.forEach((k, v) -> {
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
        String[][] matrix = output.getMatrix();
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
                +"\t\"reward\": " + output.getReward() +",\n"
                +"\t\"applied_winning_combinations\": {\n"
                + combinationStringBuilder
                +"\t},\n"
                +"\t\"applied_bonus_symbols\":" + bonusString
                +"\n"
                +"}";
    }

}
