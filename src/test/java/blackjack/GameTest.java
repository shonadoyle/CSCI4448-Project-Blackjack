package blackjack;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    private static class RecordingListener implements GameListener {

        private final List<String> events = new ArrayList<>();

        @Override
        public void onCardDealt(Player player, Card card) {
            events.add("dealt:" + player.getName());
        }

        @Override
        public void onPlayerStand(Player player) {
            events.add("stand:" + player.getName());
        }

        @Override
        public void onPlayerBust(Player player) {
            events.add("bust:" + player.getName());
        }
    }

    @Test
    void testDealInitialCardsNotifiesListener() {
        Player alice = PlayerFactory.createHumanPlayer("Alice");
        AutomatedPlayer dealer = PlayerFactory.createDealer();
        Game game = new Game(new Deck(), List.of(alice, dealer));
        RecordingListener listener = new RecordingListener();
        game.addListener(listener);

        game.dealInitialCards();

        assertEquals(2, alice.getHand().getCards().size());
        assertEquals(2, dealer.getHand().getCards().size());
        assertEquals(4, listener.events.size());
    }

    @Test
    void testDealerTurnEndsWithStandOrBust() {
        AutomatedPlayer dealer = PlayerFactory.createDealer();
        Deck deck = new Deck();
        deck.shuffle();
        Game game = new Game(deck, List.of(dealer));
        RecordingListener listener = new RecordingListener();
        game.addListener(listener);

        game.dealInitialCards();
        game.playTurn(dealer);

        String lastEvent = listener.events.get(listener.events.size() - 1);
        if (dealer.getHand().isBusted()) {
            assertEquals("bust:Dealer", lastEvent);
        } else {
            assertEquals("stand:Dealer", lastEvent);
            assertTrue(dealer.getHand().getValue() >= 17);
        }
    }

    @Test
    void testRemovedListenerIsNotNotified() {
        Player alice = PlayerFactory.createHumanPlayer("Alice");
        Game game = new Game(new Deck(), List.of(alice));
        RecordingListener listener = new RecordingListener();
        game.addListener(listener);
        game.removeListener(listener);

        game.dealInitialCards();

        assertTrue(listener.events.isEmpty());
    }
}
