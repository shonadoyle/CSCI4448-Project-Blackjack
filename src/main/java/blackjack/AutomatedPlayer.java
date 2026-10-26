package blackjack;

import java.util.Objects;

public class AutomatedPlayer extends Player {

    private final DecisionStrategy strategy;

    public AutomatedPlayer(String name, DecisionStrategy strategy) {
        super(name);
        this.strategy = Objects.requireNonNull(strategy, "Strategy cannot be null");
    }

    public boolean shouldHit() {
        return strategy.shouldHit(getHand());
    }
}