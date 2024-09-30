package org.tuncer.scratch.calculator.finder;

import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.SymbolType;
import org.tuncer.scratch.config.WinCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalLTRSymbolsFinder {

    private final Symbol[][] matrix;
    private final GameConfig gameConfig;

    public DiagonalLTRSymbolsFinder(final Symbol[][] matrix, final GameConfig gameConfig) {
        this.matrix = matrix;
        this.gameConfig = gameConfig;
    }

    public Map<Symbol, WinCombination> find() {
        Map<Symbol, WinCombination> combinations = new HashMap<>();

        List<Symbol> symbols = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if(i ==j){
                    symbols.add(matrix[i][j]);
                }
            }
        }
        boolean allEqual = symbols.stream().distinct().count() == 1;
        if (allEqual && !symbols.get(0).getType().equals(SymbolType.bonus)) {
            combinations.put(symbols.get(0), gameConfig.getWinCombinations().getSameSymbolsDiagonallyLeftToRight());
        }

        return combinations;
    }
}
