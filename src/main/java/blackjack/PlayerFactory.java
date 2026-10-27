package blackjack;

public class PlayerFactory {

    public static Player createHumanPlayer(String name) {
        return new Player(name);
    }

    public static AutomatedPlayer createDealer() {
        return new AutomatedPlayer("Dealer", new DealerStrategy());
    }

    public static AutomatedPlayer createConservativePlayer(String name) {
        return new AutomatedPlayer(name, new ConservativeStrategy());
    }
}
