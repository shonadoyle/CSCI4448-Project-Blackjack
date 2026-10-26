package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void testValidCard() {
        Card card = new Card("Hearts", "King");

        assertEquals("Hearts", card.getSuit());
        assertEquals("King", card.getRank());
        assertEquals(10, card.getValue());
    }

    @Test
    void testAceValue() {
        Card card = new Card("Spades", "Ace");
        assertEquals(11, card.getValue());
    }

    @Test
    void testNumberCardValue() {
        Card card = new Card("Diamonds", "7");
        assertEquals(7, card.getValue());
    }

    @Test
    void testInvalidSuit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("Banana", "King");
        });
    }

    @Test
    void testInvalidRank() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Card("Hearts", "15");
        });
    }
}