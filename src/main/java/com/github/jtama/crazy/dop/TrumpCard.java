package com.github.jtama.crazy.dop;

import java.util.Objects;

public class TrumpCard implements PlayingCard {
    private final Integer index;

    public TrumpCard(Integer index) {
        if (index == null || index < 0 || index >= 22)
            throw new IndexOutOfBoundsException("Index must be positive and smaller than 22.");
        this.index = index;
    }
    

    @Override
    public Integer index() {
        return this.index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrumpCard)) return false;
        TrumpCard trumpCard = (TrumpCard) o;
        return Objects.equals(index, trumpCard.index);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(index);
    }
}
