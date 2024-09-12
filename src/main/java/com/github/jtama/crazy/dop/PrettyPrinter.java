package com.github.jtama.crazy.dop;

import java.util.List;
import java.util.stream.Collectors;

public class PrettyPrinter {

    public static String toString(List<PlayingCard> cards) {
        return cards.stream()
                .map(PrettyPrinter::toString)
                .collect(Collectors.joining("," + System.lineSeparator()));
    }




    public static String toString(PlayingCard playingCard) {
        if(playingCard instanceof SuitCard suitCard){
            if(null == suitCard.face()){
                return "The" + suitCard.face().displayName() +
                        " of " +
                        suitCard.color().name().toLowerCase()+"("+ suitCard.color().getSymbol() + ")"+
                        " is strong";
            }

            if(suitCard.index() >= 7){
                return "The"+ suitCard.index() + "th of" + suitCard.color().name().toLowerCase()+"("+ suitCard.color().getSymbol() + ")"+
                        " may win you a hand";
            }
        }

        switch (playingCard){
            case TrumpCard(Integer idx): return "The trump n°%s is strong".formatted(idx);
            case SuitCard suitCard when suitCard.index() == 1 : return  "The first of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case SuitCard suitCard when suitCard.index() == 2 : return "The second of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case SuitCard suitCard when suitCard.index() == 3 : return "The third of %s(%s) is very weak".formatted(suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            case SuitCard suitCard when suitCard.index() < 7 : return "The %sth of %s(%s) is still weak".formatted(suitCard.index(),suitCard.color().name().toLowerCase(), suitCard.color().getSymbol());
            default:
                throw new IllegalStateException("Unexpected value: " + playingCard);
        }

    }
}
