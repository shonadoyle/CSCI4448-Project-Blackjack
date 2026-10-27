package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        reset();
    }

    public void reset() {
        cards.clear();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void resetAndShuffle() {
        reset();
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Cannot draw from an empty deck");
        }

        return cards.remove(0);
    }

    public int getRemainingCards() {
        return cards.size();
    }

}
