package blackjack;

public interface GameListener {

    void onCardDealt(Player player, Card card);

    void onPlayerStand(Player player);

    void onPlayerBust(Player player);

}
