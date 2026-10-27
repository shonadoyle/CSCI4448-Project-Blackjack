package blackjack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testPlayerName() {
        Player player = new Player("Shona");

        assertEquals("Shona", player.getName());
    }

    @Test
    void testNullName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player(null);
        });
    }

    @Test
    void testBlankName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Player("   ");
        });
    }

    @Test
    void testReceiveCard() {
        Player player = new Player("Shona");

        player.receiveCard(new Card(Suit.HEARTS, Rank.KING));

        assertEquals(10, player.getHand().getValue());
        assertEquals(1, player.getHand().getCards().size());
    }

    @Test
    void testClearHand() {
        Player player = new Player("Shona");

        player.receiveCard(new Card(Suit.HEARTS, Rank.ACE));
        player.clearHand();

        assertEquals(0, player.getHand().getCards().size());
        assertEquals(0, player.getHand().getValue());
    }
}