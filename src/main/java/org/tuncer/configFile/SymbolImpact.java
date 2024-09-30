package org.tuncer.configFile;

public enum SymbolImpact {

    multiply_reward("multiply_reward"),
    extra_bonus("extra_bonus"),
    miss("miss");

    private final String impact;

    SymbolImpact(String impact){
        this.impact = impact;
    }

    public String getImpact() {
        return impact;
    }
}
