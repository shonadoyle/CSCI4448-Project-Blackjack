package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AutomatedPlayerTest {

    @Test
    void testConservativeStrategy() {
        AutomatedPlayer player = new AutomatedPlayer(
                "Conservative", new ConservativeStrategy()
        );

        player.receiveCard(new Card("Hearts", "10"));
        player.receiveCard(new Card("Spades", "5"));

        assertFalse(player.shouldHit());
    }

    @Test
    void testDealerStrategy() {
        AutomatedPlayer player = new AutomatedPlayer(
                "Dealer", new DealerStrategy()
        );

        player.receiveCard(new Card("Hearts", "10"));
        player.receiveCard(new Card("Spades", "5"));

        assertTrue(player.shouldHit());
    }

    @Test
    void testNullStrategy() {
        assertThrows(NullPointerException.class, () -> {
            new AutomatedPlayer("Invalid", null);
        });
    }
}