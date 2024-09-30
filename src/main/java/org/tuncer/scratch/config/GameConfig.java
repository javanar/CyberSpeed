package org.tuncer.scratch.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameConfig {

    private int columns;
    private int rows;

    private Symbols symbols;

    private Probabilities probabilities;

    private WinCombinations winCombinations;

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Symbols getSymbols() {
        return symbols;
    }

    public void setSymbols(Symbols symbols) {
        this.symbols = symbols;
    }

    public Probabilities getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(Probabilities probabilities) {
        this.probabilities = probabilities;
    }

    @JsonProperty("win_combinations")
    public WinCombinations getWinCombinations() {
        return winCombinations;
    }
}
