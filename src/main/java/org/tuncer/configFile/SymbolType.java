package org.tuncer.configFile;

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
