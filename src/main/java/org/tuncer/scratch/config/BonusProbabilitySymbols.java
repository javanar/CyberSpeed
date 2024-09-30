package org.tuncer.scratch.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BonusProbabilitySymbols {

    private int multiplyByTen;
    private int multiplyByFive;
    private int plusOneThousand;
    private int plusFiveHundred;
    private int miss;

    @JsonProperty("10x")
    public int getMultiplyByTen() {
        return multiplyByTen;
    }

    public void setMultiplyByTen(int multiplyByTen) {
        this.multiplyByTen = multiplyByTen;
    }

    @JsonProperty("5x")
    public int getMultiplyByFive() {
        return multiplyByFive;
    }

    public void setMultiplyByFive(int multiplyByFive) {
        this.multiplyByFive = multiplyByFive;
    }

    @JsonProperty("+1000")
    public int getPlusOneThousand() {
        return plusOneThousand;
    }

    public void setPlusOneThousand(int plusOneThousand) {
        this.plusOneThousand = plusOneThousand;
    }

    @JsonProperty("+500")
    public int getPlusFiveHundred() {
        return plusFiveHundred;
    }

    public void setPlusFiveHundred(int plusFiveHundred) {
        this.plusFiveHundred = plusFiveHundred;
    }

    @JsonProperty("MISS")
    public int getMiss() {
        return miss;
    }

    public void setMiss(int miss) {
        this.miss = miss;
    }
}
