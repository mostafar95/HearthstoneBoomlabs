package playGame;

import EnemyMinions.*;
import FriendlyMinions.IMinion;

import java.util.ArrayList;
import java.util.List;

public class EnemyBoard implements IBoard {
    List deadMinionsenemy = new ArrayList();
    List<String> enemyBoard = new ArrayList<String>();
    List<IMinion> enemBoard = new ArrayList<>();

    private int boardsize = 0;
    GiantMastodon gm = new GiantMastodon();
    JadeGolem jg = new JadeGolem();
    Kuun kuun = new Kuun();
    Seagiand sg = new Seagiand();
    StormwindChampion storm = new StormwindChampion();
    Tyrantus tyrantus = new Tyrantus();
    Ultrasaur ultra = new Ultrasaur();

    @Override
    public void doTurn() {
        if (gm.getMinionHealth() <= 0) {
            removeMinion("gm");
            //deadMinionsenemy.add("gm");
        }
        if (jg.getMinionHealth() <= 0) {
            removeMinion("jg");
            //deadMinionsenemy.add("jg");

        }
        if (kuun.getMinionHealth() <= 0) {
            removeMinion("kuun");
            //deadMinionsenemy.add("kuun");

        }
        if (sg.getMinionHealth() <= 0) {
            removeMinion("sg");
            //deadMinionsenemy.add("sg");

        }
        if (storm.getMinionHealth() <= 0) {
            removeMinion("storm");
            //deadMinionsenemy.add("storm");

        }
        if (tyrantus.getMinionHealth() <= 0) {
            removeMinion("tyrantus");
            //deadMinionsenemy.add("tyrantus");

        }
        if (ultra.getMinionHealth() <= 0) {
            removeMinion("ultra");
            //deadMinionsenemy.add("ultra");

        }
    }

    @Override
    public void startofGame() {
        enemyBoard.add("storm");
        enemyBoard.add("tyrantus");
        enemyBoard.add("gm");
        enemyBoard.add("ultra");
        enemyBoard.add("sg");
        enemyBoard.add("kuun");
        enemyBoard.add("jg");

        enemBoard.add(storm);
        enemBoard.add(tyrantus);
        enemBoard.add(gm);
        enemBoard.add(ultra);
        enemBoard.add(sg);
        enemBoard.add(kuun);
        enemBoard.add(jg);

        gm.dealDamage(-1);
        gm.removeAtk(-1);
        jg.dealDamage(-1);
        jg.removeAtk(-1);
        kuun.dealDamage(-1);
        kuun.removeAtk(-1);
        sg.dealDamage(-1);
        sg.removeAtk(-1);
        tyrantus.dealDamage(-1);
        tyrantus.removeAtk(-1);
        ultra.dealDamage(-1);
        ultra.removeAtk(-1);
    }

    @Override
    public void removeMinion(String minionName) {
        for (int i = 0; i < enemyBoard.size(); i++) {
            if (enemyBoard.get(i) == minionName) {
                enemBoard.remove(i);
                enemyBoard.remove(i);
                boardsize--;
            }
        }
    }

    @Override
    public void addMinion(String minionName) {
        if (boardsize <= 7)
            enemyBoard.add(minionName);
        boardsize++;
    }

    @Override
    public String getMinion(String minionName) {
        if (enemyBoard.contains(minionName)) {
            for (int i = 0; i < enemyBoard.size(); i++) {
                if (enemyBoard.get(i) == minionName) {
                    return minionName;
                }
            }
        }
        System.out.println("Friendly friendlyBoard does not contain that minion");
        return "";
    }

    @Override
    public void addMinion(String minionName, int index) {
        if (boardsize <= 7)
            enemyBoard.add(index, minionName);
        boardsize++;
    }

    public IMinion getMinionName(String minion) {
        if (enemyBoard.contains(minion)) {
            for (int i = 0; i < enemyBoard.size(); i++) {
                if (enemyBoard.get(i) == minion) {
                    return enemBoard.get(i);
                }
            }
        }
        return null;
    }

    public int getMinionpos(String minion) {
        if (enemyBoard.contains(minion)) {
            for (int i = 0; i < enemyBoard.size(); i++) {
                if (enemyBoard.get(i) == minion) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int getBoardSize() {
        return boardsize;
    }
}
