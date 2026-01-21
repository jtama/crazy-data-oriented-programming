package com.github.jtama.crazy.dop;

import java.util.List;
import java.util.stream.Collectors;

public class GrohlOMeter {

    public static String advices(List<PlayingCard> cards) {
        return cards.stream()
                .map(GrohlOMeter::onTheGrohlScale)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }


    public static String onTheGrohlScale(PlayingCard playingCard) {
        return switch (playingCard) {
            case TrumpCard(Integer idx) -> "The trump n°%s is strong".formatted(idx);
            case NumberSuitCard suitCard when suitCard.index() == 1 -> "The first of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case NumberSuitCard suitCard when suitCard.index() == 2 -> "The second of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case NumberSuitCard suitCard when suitCard.index() == 3 -> "The third of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case NumberSuitCard suitCard when suitCard.index() < 7 -> "The %sth of %s(%s) is still weak".formatted(suitCard.index(),suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case NumberSuitCard(Color color, Integer index) -> "The %sth of %s(%s) may win you a hand".formatted(index, color.name().toLowerCase(), color.getSymbol());
            case RoyalSuitCard(Color color, Face face) -> "The %s of %s(%s) is strong".formatted(face.displayName(), color.name().toLowerCase(), color.getSymbol());
        };
    }
}
