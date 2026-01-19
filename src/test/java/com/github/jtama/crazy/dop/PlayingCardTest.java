package com.github.jtama.crazy.dop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PlayingCardTest {


    @ParameterizedTest
    @MethodSource("numberSuitInputs")
    void testNumberSuitCardConstructorValidatesInputs(Color color, Integer index, String messagePart) {
        assertThatThrownBy(() -> new NumberSuitCard(color, index))
                .isInstanceOfAny(IllegalArgumentException.class, NullPointerException.class)
                .hasMessageContaining(messagePart);
    }

    @ParameterizedTest
    @MethodSource("royalSuitInputs")
    void testRoyalSuitCardConstructorValidatesInputs(Color color, Face face, String messagePart) {
        assertThatThrownBy(() -> new RoyalSuitCard(color, face))
                .isInstanceOfAny(IllegalArgumentException.class, NullPointerException.class)
                .hasMessageContaining(messagePart);
    }

    @ParameterizedTest(name = "Validate for {0}")
    @MethodSource("cardProvider")
    void testCardDisplay(PlayingCard card, String expected) {
        assertThat(GrohlOMeter.onTheGrohlScale(card)).isEqualTo(expected);
    }

    static Stream<Arguments> numberSuitInputs() {
        return Stream.of(
                arguments(Color.CLUBS, 0, "Index"),
                arguments(Color.CLUBS, -1, "Index"),
                arguments(Color.CLUBS, 16, "Index"),
                arguments(Color.CLUBS, null, "Index"),
                arguments(null, 1, "Color")
        );

    }

    static Stream<Arguments> royalSuitInputs() {
        return Stream.of(
                arguments(Color.CLUBS, null, "Face"),
                arguments(null, Face.JACK, "Color")
        );

    }


    static Stream<Arguments> cardProvider() {
        return Stream.of(
                arguments(new NumberSuitCard(Color.CLUBS, 1), "The first of clubs(♣) is very weak"),
                arguments(new NumberSuitCard(Color.SPADES, 2), "The second of spades(♠) is very weak"),
                arguments(new NumberSuitCard(Color.DIAMONDS, 3), "The third of diamonds(♦) is very weak"),
                arguments(new NumberSuitCard(Color.HEARTS, 5), "The 5th of hearts(♥) is still weak"),
                arguments(new NumberSuitCard(Color.DIAMONDS, 7), "The 7th of diamonds(♦) may win you a hand"),
                arguments(new RoyalSuitCard(Color.SPADES, Face.JACK), "The Jack of spades(♠) is strong"),
                arguments(new TrumpCard(21), "The trump n°21 is strong")
        );

    }


    private String FULL_DECK = """
            The first of spades is very weak,
            The first of hearts is very weak,
            The first of clubs is very weak,
            The first of diamonds is very weak,
            The second of spades is very weak,
            The second of hearts is very weak,
            The second of clubs is very weak,
            The second of diamonds is very weak,
            The third of spades is very weak,
            The third of hearts is very weak,
            The third of clubs is very weak,
            The third of diamonds is very weak,
            The 4th of spades is still weak,
            The 4th of hearts is still weak,
            The 4th of clubs is still weak,
            The 4th of diamonds is still weak,
            The 5th of spades is still weak,
            The 5th of hearts is still weak,
            The 5th of clubs is still weak,
            The 5th of diamonds is still weak,
            The 6th of spades is still weak,
            The 6th of hearts is still weak,
            The 6th of clubs is still weak,
            The 6th of diamonds is still weak,
            The 7th of spades is may win you a hand,
            The 7th of hearts is may win you a hand,
            The 7th of clubs is may win you a hand,
            The 7th of diamonds is may win you a hand,
            The 8th of spades is may win you a hand,
            The 8th of hearts is may win you a hand,
            The 8th of clubs is may win you a hand,
            The 8th of diamonds is may win you a hand,
            The 9th of spades is may win you a hand,
            The 9th of hearts is may win you a hand,
            The 9th of clubs is may win you a hand,
            The 9th of diamonds is may win you a hand,
            The Jack of spades is string,
            The Knight of spades is string,
            The Queen of spades is string,
            The King of spades is string,
            The Jack of hearts is string,
            The Knight of hearts is string,
            The Queen of hearts is string,
            The King of hearts is string,
            The Jack of clubs is string,
            The Knight of clubs is string,
            The Queen of clubs is string,
            The King of clubs is string,
            The Jack of diamonds is string,
            The Knight of diamonds is string,
            The Queen of diamonds is string,
            The King of diamonds is string,
            Trump: Number 0 is strong,
            Trump: Number 1 is strong,
            Trump: Number 2 is strong,
            Trump: Number 3 is strong,
            Trump: Number 4 is strong,
            Trump: Number 5 is strong,
            Trump: Number 6 is strong,
            Trump: Number 7 is strong,
            Trump: Number 8 is strong,
            Trump: Number 9 is strong,
            Trump: Number 10 is strong,
            Trump: Number 11 is strong,
            Trump: Number 12 is strong,
            Trump: Number 13 is strong,
            Trump: Number 14 is strong,
            Trump: Number 15 is strong,
            Trump: Number 16 is strong,
            Trump: Number 17 is strong,
            Trump: Number 18 is strong,
            Trump: Number 19 is strong,
            Trump: Number 20 is strong,
            Trump: Number 21 is strong
            """;
}