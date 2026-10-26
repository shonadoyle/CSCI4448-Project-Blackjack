package blackjack;

public class DealerStrategy implements DecisionStrategy {

    @Override
    public boolean shouldHit(Hand hand) {
        return hand.getValue() < 17;
    }
}