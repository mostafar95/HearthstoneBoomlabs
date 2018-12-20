package playGame;

public interface IBoard {

    void doTurn();

    void startofGame();

    void removeMinion(String minionName);

    void addMinion(String minionName);

    String getMinion(String minionName);

    void addMinion(String minionName, int index);

    int getBoardSize();

}
