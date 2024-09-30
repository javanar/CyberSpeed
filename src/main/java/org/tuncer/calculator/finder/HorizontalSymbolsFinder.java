package org.tuncer.calculator.finder;

import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.SymbolType;
import org.tuncer.configFile.WinCombination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HorizontalSymbolsFinder {

    private final Symbol[][] matrix;
    private final GameConfig gameConfig;

    public HorizontalSymbolsFinder(final Symbol[][] matrix, final GameConfig gameConfig) {
        this.matrix = matrix;
        this.gameConfig = gameConfig;
    }

    public Map<Symbol, WinCombination> find() {
        Map<Symbol, WinCombination> combinations = new HashMap<>();

        for (Symbol[] symbols : matrix) {
            boolean allEqual = Arrays.stream(symbols).distinct().count() == 1;
            if (allEqual && !symbols[0].getType().equals(SymbolType.bonus)) {
                combinations.put(symbols[0], gameConfig.getWinCombinations().getSameSymbolsHorizontally());
            }
        }

        return combinations;
    }
}
