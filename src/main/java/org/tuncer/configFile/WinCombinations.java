package org.tuncer.configFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WinCombinations {

    private CountWinCombination sameSymbolThreeTimes;
    private CountWinCombination sameSymbolFourTimes;
    private CountWinCombination sameSymbolFiveTimes;
    private CountWinCombination sameSymbolSixTimes;
    private CountWinCombination sameSymbolSevenTimes;
    private CountWinCombination sameSymbolEightTimes;
    private CountWinCombination sameSymbolNineTimes;

    private LinearWinCombination sameSymbolsHorizontally;
    private LinearWinCombination sameSymbolsVertically;
    private LinearWinCombination sameSymbolsDiagonallyLeftToRight;
    private LinearWinCombination sameSymbolsDiagonallyRightToLeft;

    @JsonProperty("same_symbol_3_times")
    public CountWinCombination getSameSymbolThreeTimes() {
        return sameSymbolThreeTimes;
    }

    public void setSameSymbolThreeTimes(CountWinCombination sameSymbolThreeTimes) {
        this.sameSymbolThreeTimes = sameSymbolThreeTimes;
    }

    @JsonProperty("same_symbol_4_times")
    public CountWinCombination getSameSymbolFourTimes() {
        return sameSymbolFourTimes;
    }

    public void setSameSymbolFourTimes(CountWinCombination sameSymbolFourTimes) {
        this.sameSymbolFourTimes = sameSymbolFourTimes;
    }
    @JsonProperty("same_symbol_5_times")
    public CountWinCombination getSameSymbolFiveTimes() {
        return sameSymbolFiveTimes;
    }

    public void setSameSymbolFiveTimes(CountWinCombination sameSymbolFiveTimes) {
        this.sameSymbolFiveTimes = sameSymbolFiveTimes;
    }

    @JsonProperty("same_symbol_6_times")
    public CountWinCombination getSameSymbolSixTimes() {
        return sameSymbolSixTimes;
    }

    public void setSameSymbolSixTimes(CountWinCombination sameSymbolSixTimes) {
        this.sameSymbolSixTimes = sameSymbolSixTimes;
    }

    @JsonProperty("same_symbol_7_times")
    public CountWinCombination getSameSymbolSevenTimes() {
        return sameSymbolSevenTimes;
    }

    public void setSameSymbolSevenTimes(CountWinCombination sameSymbolSevenTimes) {
        this.sameSymbolSevenTimes = sameSymbolSevenTimes;
    }

    @JsonProperty("same_symbol_8_times")
    public CountWinCombination getSameSymbolEightTimes() {
        return sameSymbolEightTimes;
    }

    public void setSameSymbolEightTimes(CountWinCombination sameSymbolEightTimes) {
        this.sameSymbolEightTimes = sameSymbolEightTimes;
    }

    @JsonProperty("same_symbol_9_times")
    public CountWinCombination getSameSymbolNineTimes() {
        return sameSymbolNineTimes;
    }

    public void setSameSymbolNineTimes(CountWinCombination sameSymbolNineTimes) {
        this.sameSymbolNineTimes = sameSymbolNineTimes;
    }

    @JsonProperty("same_symbols_horizontally")
    public LinearWinCombination getSameSymbolsHorizontally() {
        return sameSymbolsHorizontally;
    }

    public void setSameSymbolsHorizontally(LinearWinCombination sameSymbolsHorizontally) {
        this.sameSymbolsHorizontally = sameSymbolsHorizontally;
    }

    @JsonProperty("same_symbols_vertically")
    public LinearWinCombination getSameSymbolsVertically() {
        return sameSymbolsVertically;
    }

    public void setSameSymbolsVertically(LinearWinCombination sameSymbolsVertically) {
        this.sameSymbolsVertically = sameSymbolsVertically;
    }

    @JsonProperty("same_symbols_diagonally_left_to_right")
    public LinearWinCombination getSameSymbolsDiagonallyLeftToRight() {
        return sameSymbolsDiagonallyLeftToRight;
    }

    public void setSameSymbolsDiagonallyLeftToRight(LinearWinCombination sameSymbolsDiagonallyLeftToRight) {
        this.sameSymbolsDiagonallyLeftToRight = sameSymbolsDiagonallyLeftToRight;
    }

    @JsonProperty("same_symbols_diagonally_right_to_left")
    public LinearWinCombination getSameSymbolsDiagonallyRightToLeft() {
        return sameSymbolsDiagonallyRightToLeft;
    }

    public void setSameSymbolsDiagonallyRightToLeft(LinearWinCombination sameSymbolsDiagonallyRightToLeft) {
        this.sameSymbolsDiagonallyRightToLeft = sameSymbolsDiagonallyRightToLeft;
    }
}
