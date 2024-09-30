package org.tuncer.calculator.finder;

import org.tuncer.configFile.BonusSymbol;
import org.tuncer.configFile.Symbol;
import org.tuncer.configFile.SymbolType;

import java.util.Arrays;

public class BonusSymbolFinder {

    private final Symbol[][] matrix;

    public BonusSymbolFinder(final Symbol[][] matrix) {
        this.matrix = matrix;
    }

    public BonusSymbol[] getBonusSymbols() {
        return Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .filter(s -> s.getType().equals(SymbolType.bonus))
                .filter(s-> !s.getExplanation().equals("miss"))
                .map(s -> (BonusSymbol)s)
                .toArray(BonusSymbol[]::new);
    }
}
