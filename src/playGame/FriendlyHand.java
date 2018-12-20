package playGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import FriendlyHand.*;

public class FriendlyHand implements IPlayerHand {
    List<String> hand = new ArrayList<>();
    Stack cardPlayed = new Stack();
    ArcaneAnomaly arcane = new ArcaneAnomaly();
    BloodfuryPotion blood = new BloodfuryPotion();
    Deamonfire deamon = new Deamonfire();
    Defile defile = new Defile();
    MoatLurker moat = new MoatLurker();
    RatCatcher rat = new RatCatcher();
    VoidTerror voidTerror = new VoidTerror();
    private int playerMana = 70;

    @Override
    public void startofGame() {
        hand.add("arcane");
        hand.add("blood");
        hand.add("deamon");
        hand.add("defile");
        hand.add("moat");
        hand.add("rat");
        hand.add("voidterror");
    }

    @Override
    public int getPlayerMana() {
        return playerMana;
    }

    @Override
    public int getHandSize() {
        return hand.size();
    }

    @Override
    public void useMana(int cost) {
        playerMana = playerMana - cost;
    }

    public void setMana(int newmana){ playerMana = newmana;}
}
