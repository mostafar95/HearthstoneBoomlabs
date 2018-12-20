package playGame;

import FriendlyMinions.*;

import java.util.*;

public class FriendlyBoard implements IBoard{
    List deadMinionsfriend = new ArrayList();
    public List <String> friendlyBoard = new ArrayList<String>();
    public List <IMinion> friendBoard = new ArrayList<>();
    WildPyromancer wp = new WildPyromancer();
    SorcressAprentice sorce = new SorcressAprentice();
    SorcressAprentice sorce2 = new SorcressAprentice();
    FearsomeDoomguard fd = new FearsomeDoomguard();
    SummoningPortal sp = new SummoningPortal();
    //private int boardsize = 0;

    @Override
    public void doTurn() {
        if(wp.getMinionHealth() <= 0){
            removeMinion("wp");
            //deadMinionsfriend.add("wp");
        }if(sorce.getMinionHealth() <= 0){
            removeMinion("sorce");
            //deadMinionsfriend.add("sorce");
        }if(sorce2.getMinionHealth() <= 0){
            removeMinion("sorce2");
            //deadMinionsfriend.add("sorce2");

        }if(fd.getMinionHealth() <= 0){
            removeMinion("fd");
            //deadMinionsfriend.add("fd");

        }if(sp.getMinionHealth() <= 0){
            removeMinion("sp");
            //deadMinionsfriend.add("sp");

        }
    }

    @Override
    public void startofGame() {
        friendlyBoard.add("sorce");
        friendlyBoard.add("wp");
        friendlyBoard.add("sorce2");
        friendlyBoard.add("fd");
        friendlyBoard.add("sp");

        friendBoard.add(sorce);
        friendBoard.add(wp);
        friendBoard.add(sorce2);
        friendBoard.add(fd);
        friendBoard.add(sp);
    }

    @Override
    public void removeMinion(String minionName) {
        for (int i = 0; i < friendlyBoard.size(); i++) {
            if(friendlyBoard.get(i) == minionName){
                friendlyBoard.remove(i);
                friendBoard.remove(i);
            }
        }
    }

    @Override
    public void addMinion(String minionName) {
        if(friendBoard.size() < 7) {
            friendlyBoard.add(minionName);
        }
    }

    public void addMinionPos(String minionName, IMinion minionName2) {
        int random = (int) (Math.random() * getBoardSize() + 1);
        if (friendBoard.size() < 7) {
            friendlyBoard.add(random-1, minionName);
            friendBoard.add(random-1, minionName2);
        }
    }

    @Override
    public String getMinion(String minionName) {
        if (friendlyBoard.contains(minionName)){
            for (int i = 0; i < friendlyBoard.size(); i++) {
                if(friendlyBoard.get(i) == minionName){
                    return minionName;
                }
            }
        }
        System.out.println("Friendly friendlyBoard does not contain that minion");
        return "";
    }

    public int getMinionPos(String minionName) {
        if (friendlyBoard.contains(minionName)){
            for (int i = 0; i < friendlyBoard.size(); i++) {
                if(friendlyBoard.get(i) == minionName){
                    return i;
                }
            }
        }
        System.out.println("Friendly friendlyBoard does not contain that minion");
        return -1;
    }

    public IMinion getMinionName(int minionPos) {
            return friendBoard.get(minionPos);
    }

    @Override
    public void addMinion(String minionName, int index) {
        if(friendBoard.size() <= 7)
            friendlyBoard.add(index, minionName);
    }

    @Override
    public int getBoardSize() {
        return friendBoard.size();
    }
}
