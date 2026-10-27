package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    void testDeckHas52Cards() {
        Deck deck = new Deck();

        assertEquals(52, deck.getRemainingCards());
    }

    @Test
    void testDrawCard() {
        Deck deck = new Deck();

        Card card = deck.drawCard();

        assertNotNull(card);
        assertEquals(51, deck.getRemainingCards());
    }

    @Test
    void testDrawFromEmptyDeck() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }

        assertEquals(0, deck.getRemainingCards());

        assertThrows(IllegalStateException.class, deck::drawCard);
    }

    @Test
    void testResetRestoresFullDeck() {
        Deck deck = new Deck();

        for (int i = 0; i < 10; i++) {
            deck.drawCard();
        }

        deck.reset();

        assertEquals(52, deck.getRemainingCards());
    }

    @Test
    void testResetAndShuffleRestoresFullDeck() {
        Deck deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }

        deck.resetAndShuffle();

        assertEquals(52, deck.getRemainingCards());
        assertNotNull(deck.drawCard());
    }
}