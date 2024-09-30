package org.tuncer.scratch.config;

public enum SymbolType {

    standard("standard"),
    bonus("bonus"),
    miss("miss");

    private final String type;

    SymbolType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
