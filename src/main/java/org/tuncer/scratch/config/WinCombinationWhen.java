package org.tuncer.scratch.config;

public enum WinCombinationWhen {

    same_symbols("same_symbols"),
    linear_symbols("linear_symbols");

    private final String when;

    WinCombinationWhen(String when) {
        this.when = when;
    }

    public String getWhen() {
        return when;
    }
}
