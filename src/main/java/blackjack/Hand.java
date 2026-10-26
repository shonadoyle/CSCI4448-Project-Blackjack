package blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Cannot add a null card");
        }

        cards.add(card);
    }

    public int getValue() {
        int total = 0;
        int aceCount = 0;

        for (Card card : cards) {
            total += card.getValue();

            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }

        while (total > 21 && aceCount > 0) {
            total -= 10;
            aceCount--;
        }

        return total;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    public boolean isBlackjack() {
        return cards.size() == 2 && getValue() == 21;
    }

    public List<Card> getCards() {
        return List.copyOf(cards);
    }
}