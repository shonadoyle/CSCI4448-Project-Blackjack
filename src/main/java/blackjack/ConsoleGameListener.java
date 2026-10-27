package blackjack;

public class ConsoleGameListener implements GameListener {

    @Override
    public void onCardDealt(Player player, Card card) {
        System.out.println(player.getName() + " is dealt the " + card);
    }

    @Override
    public void onPlayerStand(Player player) {
        System.out.println(player.getName() + " stands with " + player.getHand().getValue());
    }

    @Override
    public void onPlayerBust(Player player) {
        System.out.println(player.getName() + " busts with " + player.getHand().getValue());
    }
}
