package org.tuncer.scratch.calculator;

import org.tuncer.scratch.calculator.finder.BonusSymbolFinder;
import org.tuncer.scratch.calculator.finder.WinCombinationFinder;
import org.tuncer.scratch.config.BonusSymbol;
import org.tuncer.scratch.config.Symbol;
import org.tuncer.scratch.config.WinCombination;

import java.util.List;
import java.util.Map;

public class MatrixAnalyzer {

    private final WinCombinationFinder winCombinationFinder;
    private final BonusSymbolFinder bonusSymbolFinder;

    public MatrixAnalyzer(WinCombinationFinder winCombinationFinder, BonusSymbolFinder bonusSymbolFinder) {
        this.winCombinationFinder = winCombinationFinder;
        this.bonusSymbolFinder = bonusSymbolFinder;
    }

    public Map<Symbol, List<WinCombination>> getWinningCombinations() {
       return winCombinationFinder.getWinningCombinations();
    }

    public BonusSymbol[] getBonusSymbols() {
        return bonusSymbolFinder.getBonusSymbols();
    }
}
