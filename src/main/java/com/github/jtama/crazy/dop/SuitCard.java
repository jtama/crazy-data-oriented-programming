package com.github.jtama.crazy.dop;

public sealed interface SuitCard extends PlayingCard permits NumberSuitCard, RoyalSuitCard {
    Color color();
}