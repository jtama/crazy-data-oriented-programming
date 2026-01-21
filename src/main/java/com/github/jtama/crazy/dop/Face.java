package com.github.jtama.crazy.dop;

public enum Face {
    JACK("Jack", 11),
    KNIGTH("Knight", 12),
    QUEEN("Queen", 13),
    KING("King", 14);

    private final String displayName;
    private Integer index;

    Face(String displayName, Integer index) {
        this.displayName = displayName;
        this.index = index;
    }

    public String displayName() {
        return displayName;
    }

    public Integer index() {
        return index;
    }
}