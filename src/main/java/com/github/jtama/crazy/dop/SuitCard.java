package com.github.jtama.crazy.dop;

import java.util.Objects;

public class SuitCard implements PlayingCard {
    private final Color color;
    private final Integer index;
    private final Face face;

    public SuitCard(Color color, Integer index, Face face) {
        if (color == null)
            throw new IllegalArgumentException("Color must not be null.");
        if (index == null)
            throw new IllegalArgumentException("Index must not be null.");
        if (index < 1)
            throw new IndexOutOfBoundsException("Index must be positive.");
        if (index > 15)
            throw new IndexOutOfBoundsException("Index must be lesser than 15.");
        if (index > 10 && face == null)
            throw new IllegalArgumentException("Face must not be null for index greater than 10.");
        if (index < 11 && face != null)
            throw new IllegalArgumentException("Face must be null for index lesser than 11.");
        this.color = color;
        this.index = index;
        this.face = face;
    }

    public Face face() {
        return face;
    }

    public Color color() {
        return color;
    }

    @Override
    public Integer index() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SuitCard)) return false;
        SuitCard suitCard = (SuitCard) o;
        return color == suitCard.color && Objects.equals(index, suitCard.index) && face == suitCard.face;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, index, face);
    }

}
