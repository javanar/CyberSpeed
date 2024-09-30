package org.tuncer.scratch.config;

public enum WinCombinationGroup {

    same_symbols("same_symbols"),
    horizontally_linear_symbols("horizontally_linear_symbols"),
    vertically_linear_symbols("vertically_linear_symbols"),
    ltr_diagonally_linear_symbols("ltr_diagonally_linear_symbols"),
    rtl_diagonally_linear_symbols("rtl_diagonally_linear_symbols");

    private final String group;

    WinCombinationGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }
}
