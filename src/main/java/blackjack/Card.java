package blackjack;

public class Card {

    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {

        // Validate suit
        if (suit == null ||
                !(suit.equals("Hearts") ||
                        suit.equals("Diamonds") ||
                        suit.equals("Clubs") ||
                        suit.equals("Spades"))) {

            throw new IllegalArgumentException("Invalid card suit: " + suit);
        }

        // Validate rank
        if (rank == null ||
                !(rank.equals("Ace") ||
                        rank.equals("King") ||
                        rank.equals("Queen") ||
                        rank.equals("Jack") ||
                        rank.matches("([2-9]|10)"))) {

            throw new IllegalArgumentException("Invalid card rank: " + rank);
        }

        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit(){
        return this.suit;
    }

    public String getRank(){
        return this.rank;
    }

    public int getValue() {
        switch (rank) {

            case "Ace":
                return 11;

            case "King":
            case "Queen":
            case "Jack":
                return 10;

            default:
                return Integer.parseInt(rank);

        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}


