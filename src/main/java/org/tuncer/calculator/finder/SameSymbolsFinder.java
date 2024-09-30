package org.tuncer.calculator.finder;

import org.tuncer.configFile.GameConfig;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.SymbolType;
import org.tuncer.configFile.WinCombination;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SameSymbolsFinder {

    private final Symbol[][] matrix;
    private final GameConfig gameConfig;

    public SameSymbolsFinder(Symbol[][] matrix, GameConfig gameConfig) {
        this.matrix = matrix;
        this.gameConfig = gameConfig;
    }

    public Map<Symbol, WinCombination> find() {
        Map<Symbol, WinCombination> combinations = new HashMap<>();

        Map<Symbol, Long> frequencies = Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .filter(s-> !s.getType().equals(SymbolType.bonus))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Symbol, Long> winningSymbols = frequencies.entrySet().stream()
                .filter(e -> e.getValue() >= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        winningSymbols.forEach((key, value) -> combinations.put(key, determineCombination(value)));

        return combinations;
    }

    private WinCombination determineCombination(Long value) {

        switch (value.intValue()){
            case 9:
                return gameConfig.getWinCombinations().getSameSymbolNineTimes();
            case 8:
                return gameConfig.getWinCombinations().getSameSymbolEightTimes();
            case 7:
                return gameConfig.getWinCombinations().getSameSymbolSevenTimes();
            case 6:
                return gameConfig.getWinCombinations().getSameSymbolSixTimes();
            case 5:
                return gameConfig.getWinCombinations().getSameSymbolFiveTimes();
            case 4:
                return gameConfig.getWinCombinations().getSameSymbolFourTimes();
            default:
                return gameConfig.getWinCombinations().getSameSymbolThreeTimes();
        }
    }


}
