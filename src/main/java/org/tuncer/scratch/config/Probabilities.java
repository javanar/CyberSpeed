package org.tuncer.scratch.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Probabilities {

    private List<StandardSymbolProbability> standardSymbols;
    private BonusSymbolProbabilities bonusSymbols;


    @JsonProperty("standard_symbols")
    public List<StandardSymbolProbability> getStandardSymbols() {
        return standardSymbols;
    }

    public void setStandardSymbols(List<StandardSymbolProbability> standardSymbols) {
        this.standardSymbols = standardSymbols;
    }

    @JsonProperty("bonus_symbols")
    public BonusSymbolProbabilities getBonusSymbols() {
        return bonusSymbols;
    }

    public void setBonusSymbols(BonusSymbolProbabilities bonusSymbols) {
        this.bonusSymbols = bonusSymbols;
    }
}
