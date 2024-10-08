package org.tuncer.scratch.calculator.finder;

import org.tuncer.scratch.config.GameConfig;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.WinCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinCombinationFinder {

    private final SameSymbolsFinder sameSymbolsFinder;
    private final HorizontalSymbolsFinder horizontalSymbolsFinder;
    private final VerticalSymbolsFinder verticalSymbolsFinder;
    private final DiagonalLTRSymbolsFinder diagonalLTRSymbolsFinder;
    private final DiagonalRTLSymbolsFinder diagonalRTLSymbolsFinder;

    public WinCombinationFinder(final Symbol[][] matrix, final GameConfig gameConfig) {
        this.sameSymbolsFinder = new SameSymbolsFinder(matrix, gameConfig);
        this.horizontalSymbolsFinder = new HorizontalSymbolsFinder(matrix, gameConfig);
        this.verticalSymbolsFinder = new VerticalSymbolsFinder(matrix, gameConfig);
        this.diagonalLTRSymbolsFinder = new DiagonalLTRSymbolsFinder(matrix, gameConfig);
        this.diagonalRTLSymbolsFinder = new DiagonalRTLSymbolsFinder(matrix, gameConfig);
    }

    public Map<Symbol, List<WinCombination>> getWinningCombinations() {
        Map<Symbol, List<WinCombination>> winningCombinations = new HashMap<>();

        Map<Symbol, WinCombination> sameSymbols = sameSymbolsFinder.find();
        Map<Symbol, WinCombination> horizontalSymbols = horizontalSymbolsFinder.find();
        Map<Symbol, WinCombination> verticalSymbols = verticalSymbolsFinder.find();
        Map<Symbol, WinCombination> leftDiagonalSymbols = diagonalLTRSymbolsFinder.find();
        Map<Symbol, WinCombination> rightDiagonalSymbols = diagonalRTLSymbolsFinder.find();

        sameSymbols.forEach((key, value) -> {
            List<WinCombination> combinations = new ArrayList<>();
            combinations.add(value);
            winningCombinations.put(key, combinations);
        });

        horizontalSymbols.forEach((key, value) ->{
            if (winningCombinations.get(key) == null) {
                List<WinCombination> combinations = new ArrayList<>();
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }else {
                List<WinCombination> combinations = winningCombinations.get(key);
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }
        });

        verticalSymbols.forEach((key, value) ->{
            if (winningCombinations.get(key) == null) {
                List<WinCombination> combinations = new ArrayList<>();
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }else {
                List<WinCombination> combinations = winningCombinations.get(key);
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }
        });

        leftDiagonalSymbols.forEach((key, value) ->{
            if (winningCombinations.get(key) == null) {
                List<WinCombination> combinations = new ArrayList<>();
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }else {
                List<WinCombination> combinations = winningCombinations.get(key);
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }
        });

        rightDiagonalSymbols.forEach((key, value) ->{
            if (winningCombinations.get(key) == null) {
                List<WinCombination> combinations = new ArrayList<>();
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }else {
                List<WinCombination> combinations = winningCombinations.get(key);
                combinations.add(value);
                winningCombinations.put(key, combinations);
            }
        });

        return winningCombinations;
    }
}
