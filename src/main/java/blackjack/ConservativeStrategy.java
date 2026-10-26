package blackjack;

public class ConservativeStrategy implements DecisionStrategy {

    @Override
    public boolean shouldHit(Hand hand) {
        return hand.getValue() < 12;
    }
}