package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomatedPlayerTest {

    @Test
    void testConservativeStrategy() {
        AutomatedPlayer player = new AutomatedPlayer(
                "Conservative", new ConservativeStrategy()
        );

        player.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player.receiveCard(new Card(Suit.SPADES, Rank.FIVE));

        assertFalse(player.shouldHit());
    }

    @Test
    void testDealerStrategy() {
        AutomatedPlayer player = new AutomatedPlayer(
                "Dealer", new DealerStrategy()
        );

        player.receiveCard(new Card(Suit.HEARTS, Rank.TEN));
        player.receiveCard(new Card(Suit.SPADES, Rank.FIVE));

        assertTrue(player.shouldHit());
    }

    @Test
    void testNullStrategy() {
        assertThrows(NullPointerException.class, () -> {
            new AutomatedPlayer("Invalid", null);
        });
    }
}