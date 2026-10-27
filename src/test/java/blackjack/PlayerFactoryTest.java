package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerFactoryTest {

    @Test
    void testCreateHumanPlayer() {
        Player player = PlayerFactory.createHumanPlayer("Alice");

        assertEquals("Alice", player.getName());
        assertFalse(player instanceof AutomatedPlayer);
    }

    @Test
    void testCreateDealer() {
        AutomatedPlayer dealer = PlayerFactory.createDealer();

        dealer.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        dealer.receiveCard(new Card(Suit.SPADES, Rank.SIX));

        assertEquals("Dealer", dealer.getName());
        assertTrue(dealer.shouldHit());
    }

    @Test
    void testCreateConservativePlayer() {
        AutomatedPlayer player = PlayerFactory.createConservativePlayer("Bot");

        player.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player.receiveCard(new Card(Suit.SPADES, Rank.SIX));

        assertEquals("Bot", player.getName());
        assertFalse(player.shouldHit());
    }
}
