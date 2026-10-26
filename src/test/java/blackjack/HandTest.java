package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    void testHandValue() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "King"));
        hand.addCard(new Card("Spades", "7"));

        assertEquals(17, hand.getValue());
    }

    @Test
    void testAceAdjustment() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Spades", "7"));
        hand.addCard(new Card("Clubs", "9"));

        assertEquals(17, hand.getValue());
    }

    @Test
    void testMultipleAces() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Spades", "Ace"));
        hand.addCard(new Card("Clubs", "9"));

        assertEquals(21, hand.getValue());
    }

    @Test
    void testBustedHand() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "King"));
        hand.addCard(new Card("Spades", "Queen"));
        hand.addCard(new Card("Clubs", "5"));

        assertTrue(hand.isBusted());
    }

    @Test
    void testBlackjack() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "Ace"));
        hand.addCard(new Card("Spades", "King"));

        assertTrue(hand.isBlackjack());
    }

    @Test
    void testThreeCard21IsNotBlackjack() {
        Hand hand = new Hand();

        hand.addCard(new Card("Hearts", "7"));
        hand.addCard(new Card("Spades", "7"));
        hand.addCard(new Card("Clubs", "7"));

        assertFalse(hand.isBlackjack());
    }
}