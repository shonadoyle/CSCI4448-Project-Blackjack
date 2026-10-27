package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {

    @Test
    void testValidCard() {
        Card card = new Card(Suit.HEARTS, Rank.KING);

        assertEquals(Suit.HEARTS, card.getSuit());
        assertEquals(Rank.KING, card.getRank());
        assertEquals(10, card.getValue());
    }

    @Test
    void testAceValue() {
        Card card = new Card(Suit.SPADES, Rank.ACE);
        assertEquals(11, card.getValue());
    }

    @Test
    void testNumberCardValue() {
        Card card = new Card(Suit.DIAMONDS, Rank.SEVEN);
        assertEquals(7, card.getValue());
    }

    @Test
    void testToString() {
        Card card = new Card(Suit.CLUBS, Rank.QUEEN);
        assertEquals("Queen of Clubs", card.toString());
    }

    @Test
    void testNullSuit() {
        assertThrows(NullPointerException.class, () -> {
            new Card(null, Rank.KING);
        });
    }

    @Test
    void testNullRank() {
        assertThrows(NullPointerException.class, () -> {
            new Card(Suit.HEARTS, null);
        });
    }
}
