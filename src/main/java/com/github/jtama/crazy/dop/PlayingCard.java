package com.github.jtama.crazy.dop;

public sealed interface PlayingCard permits SuitCard, TrumpCard  {
    Integer index();
}