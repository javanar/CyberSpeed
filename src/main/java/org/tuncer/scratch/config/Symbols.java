package org.tuncer.scratch.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Symbols {

    private StandardSymbol A;
    private StandardSymbol B;
    private StandardSymbol C;
    private StandardSymbol D;
    private StandardSymbol E;
    private StandardSymbol F;

    private MultiplierBonusSymbol multiplyByTen;
    private MultiplierBonusSymbol multiplyByFive;

    private ExtraBonusSymbol plusOneThousand;
    private ExtraBonusSymbol plusFiveHundred;

    private MissSymbol miss;

    @JsonProperty("A")
    public StandardSymbol getA() {
        return A;
    }

    public void setA(StandardSymbol a) {
        A = a;
    }

    @JsonProperty("B")
    public StandardSymbol getB() {
        return B;
    }

    public void setB(StandardSymbol b) {
        B = b;
    }

    @JsonProperty("C")
    public StandardSymbol getC() {
        return C;
    }

    public void setC(StandardSymbol c) {
        C = c;
    }

    @JsonProperty("D")
    public StandardSymbol getD() {
        return D;
    }

    public void setD(StandardSymbol d) {
        D = d;
    }

    @JsonProperty("E")
    public StandardSymbol getE() {
        return E;
    }

    public void setE(StandardSymbol e) {
        E = e;
    }

    @JsonProperty("F")
    public StandardSymbol getF() {
        return F;
    }

    public void setF(StandardSymbol f) {
        F = f;
    }

    @JsonProperty("10x")
    public MultiplierBonusSymbol getMultiplyByTen() {
        return multiplyByTen;
    }

    public void setMultiplyByTen(MultiplierBonusSymbol multiplyByTen) {
        this.multiplyByTen = multiplyByTen;
    }

    @JsonProperty("5x")
    public MultiplierBonusSymbol getMultiplyByFive() {
        return multiplyByFive;
    }

    public void setMultiplyByFive(MultiplierBonusSymbol multiplyByFive) {
        this.multiplyByFive = multiplyByFive;
    }

    @JsonProperty("+1000")
    public ExtraBonusSymbol getPlusOneThousand() {
        return plusOneThousand;
    }

    public void setPlusOneThousand(ExtraBonusSymbol plusOneThousand) {
        this.plusOneThousand = plusOneThousand;
    }

    @JsonProperty("+500")
    public ExtraBonusSymbol getPlusFiveHundred() {
        return plusFiveHundred;
    }

    public void setPlusFiveHundred(ExtraBonusSymbol plusFiveHundred) {
        this.plusFiveHundred = plusFiveHundred;
    }

    @JsonProperty("MISS")
    public MissSymbol getMiss() {
        return miss;
    }

    public void setMiss(MissSymbol miss) {
        this.miss = miss;
    }
}
