package playGame;

public interface IPlayerHand {

    void startofGame();

    int getPlayerMana();

    int getHandSize();

    void useMana(int cost);
}
