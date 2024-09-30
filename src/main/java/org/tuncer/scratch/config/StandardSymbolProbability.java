package org.tuncer.scratch.config;

public class StandardSymbolProbability {

    private int column;
    private int row;

    private LetterSymbolProbabilities symbols;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public LetterSymbolProbabilities getSymbols() {
        return symbols;
    }

    public void setSymbols(LetterSymbolProbabilities symbols) {
        this.symbols = symbols;
    }
}
