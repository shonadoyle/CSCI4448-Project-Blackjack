package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HandTest {

    @Test
    void testHandValue() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.KING));
        hand.addCard(new Card(Suit.SPADES, Rank.SEVEN));

        assertEquals(17, hand.getValue());
    }

    @Test
    void testAceAdjustment() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        hand.addCard(new Card(Suit.SPADES, Rank.SEVEN));
        hand.addCard(new Card(Suit.CLUBS, Rank.NINE));

        assertEquals(17, hand.getValue());
    }

    @Test
    void testMultipleAces() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        hand.addCard(new Card(Suit.SPADES, Rank.ACE));
        hand.addCard(new Card(Suit.CLUBS, Rank.NINE));

        assertEquals(21, hand.getValue());
    }

    @Test
    void testBustedHand() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.KING));
        hand.addCard(new Card(Suit.SPADES, Rank.QUEEN));
        hand.addCard(new Card(Suit.CLUBS, Rank.FIVE));

        assertTrue(hand.isBusted());
    }

    @Test
    void testBlackjack() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.ACE));
        hand.addCard(new Card(Suit.SPADES, Rank.KING));

        assertTrue(hand.isBlackjack());
    }

    @Test
    void testThreeCard21IsNotBlackjack() {
        Hand hand = new Hand();

        hand.addCard(new Card(Suit.HEARTS, Rank.SEVEN));
        hand.addCard(new Card(Suit.SPADES, Rank.SEVEN));
        hand.addCard(new Card(Suit.CLUBS, Rank.SEVEN));

        assertFalse(hand.isBlackjack());
    }
}