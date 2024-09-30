package org.tuncer.calculator.finder;

import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.SymbolType;
import org.tuncer.configFile.WinCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalSymbolsFinder {

    private final Symbol[][] matrix;
    private final GameConfig gameConfig;

    public VerticalSymbolsFinder(final Symbol[][] matrix, final GameConfig gameConfig) {
        this.matrix = matrix;
        this.gameConfig = gameConfig;
    }

    public Map<Symbol, WinCombination> find() {
        Map<Symbol, WinCombination> combinations = new HashMap<>();

        List<Symbol> symbols = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix.length; j++) {
                symbols.add(matrix[j][i]);
            }
            boolean allEqual = symbols.stream().distinct().count() == 1;
            if (allEqual && !symbols.get(0).getType().equals(SymbolType.bonus)) {
                combinations.put(symbols.get(0), gameConfig.getWinCombinations().getSameSymbolsVertically());
            }
            symbols.clear();
        }

        return combinations;
    }
}
