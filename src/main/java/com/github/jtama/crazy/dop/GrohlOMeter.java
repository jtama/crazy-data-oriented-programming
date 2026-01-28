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
        if (playingCard instanceof SuitCard) {
            SuitCard suitCard = (SuitCard) playingCard;
            if (null != suitCard.face()) {
                return "The" + suitCard.face().displayName() +
                        " of " +
                        suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ")" +
                        " is strong";
            }

            switch (playingCard.index()) {
                case 1:
                    return "The first of " + suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ") is very weak";
                case 2:
                    return "The second of " + suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ") is very weak";
                case 3:
                    return "The third of " + suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ") is very weak";
                case 4:
                case 5:
                case 6:
                    return "The " + suitCard.index() + "th of " + suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ") is still weak";
                case 7:
                case 8:
                case 9:
                case 10:
                    return "The " + suitCard.index() + "th of " + suitCard.color().name().toLowerCase() + "(" + suitCard.color().getSymbol() + ") may win you a hand";
                default:
                    throw new IllegalStateException("Unexpected value: " + playingCard);
            }
        }
        return "The trump n°" + playingCard.index() + " is strong";
    }
}
