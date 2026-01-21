package com.github.jtama.crazy.dop;

import java.util.Objects;

public record NumberSuitCard(Color color, Integer index) implements SuitCard {
    public NumberSuitCard {
        Objects.requireNonNull(color, "Color cannot be null");
        Objects.requireNonNull(index, "Index cannot be null");
        if(index < 1 || index > 10){
            throw new IllegalArgumentException("Index must be between 1 and 10 included");
        }
    }
}