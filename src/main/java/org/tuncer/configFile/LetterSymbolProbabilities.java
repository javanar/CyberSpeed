package org.tuncer.configFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LetterSymbolProbabilities {

    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;

    @JsonProperty("A")
    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    @JsonProperty("B")
    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    @JsonProperty("C")
    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    @JsonProperty("D")
    public int getD() {
        return D;
    }

    public void setD(int d) {
        D = d;
    }

    @JsonProperty("E")
    public int getE() {
        return E;
    }

    public void setE(int e) {
        E = e;
    }

    @JsonProperty("F")
    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }
}
