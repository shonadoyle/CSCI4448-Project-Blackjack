package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    private final Deck deck;
    private final List<Player> players;
    private final List<GameListener> listeners;

    public Game(Deck deck, List<Player> players) {
        this.deck = Objects.requireNonNull(deck, "Deck cannot be null");
        this.players = List.copyOf(players);
        this.listeners = new ArrayList<>();
    }

    public void addListener(GameListener listener) {
        listeners.add(Objects.requireNonNull(listener, "Listener cannot be null"));
    }

    public void removeListener(GameListener listener) {
        listeners.remove(listener);
    }

    public void dealInitialCards() {
        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                dealCard(player);
            }
        }
    }

    public void playTurn(AutomatedPlayer player) {
        while (!player.getHand().isBusted() && player.shouldHit()) {
            dealCard(player);
        }

        if (player.getHand().isBusted()) {
            for (GameListener listener : listeners) {
                listener.onPlayerBust(player);
            }
        } else {
            for (GameListener listener : listeners) {
                listener.onPlayerStand(player);
            }
        }
    }

    private void dealCard(Player player) {
        Card card = deck.drawCard();
        player.receiveCard(card);

        for (GameListener listener : listeners) {
            listener.onCardDealt(player, card);
        }
    }
}
