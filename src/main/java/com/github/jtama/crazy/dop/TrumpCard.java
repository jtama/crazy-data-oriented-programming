package com.github.jtama.crazy.dop;

public record TrumpCard(Integer index) implements PlayingCard {
    public TrumpCard {
        if (index == null || index < 0 || index > 22) throw new IndexOutOfBoundsException("Index must be positive and lesser than 22.");
    }
}
