package com.github.jtama.crazy.dop;

import java.util.Objects;

public record RoyalSuitCard(Color color, Face face) implements SuitCard {
    public RoyalSuitCard {
        Objects.requireNonNull(color, "Color cannot be null");
        Objects.requireNonNull(face, "Face cannot be null");
    }

    @Override
    public Integer index() {
        return face.index();
    }
}
