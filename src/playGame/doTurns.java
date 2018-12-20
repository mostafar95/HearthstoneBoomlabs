package playGame;

import FriendlyHand.ArcaneAnomaly;
import FriendlyHand.MoatLurker;
import FriendlyHand.RatCatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class doTurns {
    FriendlyBoard player = new FriendlyBoard();
    EnemyBoard enemy = new EnemyBoard();
    FriendlyHand hand = new FriendlyHand();
    Stack cardPlayed = new Stack();
    List deadMinions = new ArrayList();
    Stack lurk = new Stack();
    String lurker = "";

    public void doDefile(int mana) {
        cardPlayed.push("defile");
        hand.useMana(mana);
        while (player.getBoardSize() != 0 && enemy.getBoardSize() != 0) {//mens minions er ilive
            if (enemy.deadMinionsenemy.isEmpty() && player.deadMinionsfriend.isEmpty()) {//breaker om ingen minions døde
                break;
            }
            enemy.deadMinionsenemy.clear();
            player.deadMinionsfriend.clear();
            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                enemy.enemBoard.get(i).dealDamage(1);
                if (!enemy.enemBoard.get(i).isAlive()) {
                    enemy.deadMinionsenemy.add(i);
                    deadMinions.add(enemy.enemyBoard.get(i));
                    enemy.enemBoard.remove(i);
                    enemy.enemyBoard.remove(i);
                }
            }
            for (int i = 0; i < player.friendBoard.size(); i++) {
                player.friendBoard.get(i).dealDamage(1);
                if (!player.friendBoard.get(i).isAlive()) {
                    player.deadMinionsfriend.add(i);
                    deadMinions.add(player.friendlyBoard.get(i));
                    player.friendBoard.remove(i);
                    player.friendlyBoard.remove(i);
                }
            }
        }
    }

    public void doArcane(int mana) {
        if (player.getBoardSize() <= 7) {
            hand.useMana(mana);
            ArcaneAnomaly ac = new ArcaneAnomaly();
            player.addMinionPos("ac", ac);
            int pos = player.getMinionPos("ac");
            cardPlayed.push("arcane on pos " + pos);
        }
    }

    public void doDeamonFire(int mana) {
        int random = (int) (Math.random() * 2 + 1);
        hand.useMana(mana);
        if (random == 1) {
            int randomNum = (int) (Math.random() * enemy.enemBoard.size()+1);
            if (enemy.enemBoard.size() > 0 && enemy.enemyBoard.get(randomNum-1).equals("tyrantus")){
                enemy.enemBoard.get(randomNum-1).dealDamage(2);
                cardPlayed.push("deamon on "+ enemy.enemBoard.get(randomNum));
            }
        } else {
            int randomNum = (int) (Math.random() * player.friendBoard.size()+1);
            if(player.friendBoard.size() > 0) {
                String minion = player.friendlyBoard.get(randomNum - 1);
                if (minion == "fd" || minion == "moat") {
                    player.friendBoard.get(randomNum - 1).dealDamage(-2);
                    player.friendBoard.get(randomNum - 1).removeAtk(-2);
                    cardPlayed.push("deamon on " + player.friendBoard.get(randomNum - 1));
                } else {
                    player.friendBoard.get(randomNum - 1).dealDamage(2);
                    cardPlayed.push("deamon on " + player.friendBoard.get(randomNum - 1));

                }
            }
        }
    }

    public void doBloodFurry(int mana) {
        int random = (int) (Math.random() * 2 + 1);
        hand.useMana(mana);
        if (random == 1) {
            int randomNum = (int) (Math.random() * enemy.enemBoard.size());
            if (enemy.enemyBoard.size() > 0 && enemy.enemyBoard.get(randomNum) != "tyrantus"){
                enemy.enemBoard.get(randomNum).removeAtk(-3);
                cardPlayed.push("blood on "+ enemy.enemBoard.get(randomNum));
            }
        } else {
            int randomNum = (int) (Math.random() * player.friendBoard.size());
            if(player.friendBoard.size() > 0) {
                String minion = player.friendlyBoard.get(randomNum);
                if (minion == "fd" || minion == "moat") {
                    player.friendBoard.get(randomNum).dealDamage(-3);
                    player.friendBoard.get(randomNum).removeAtk(-3);
                    cardPlayed.push("blood on " + player.friendBoard.get(randomNum));
                }
            }else if(enemy.enemBoard.size() > 0) {
                    enemy.enemBoard.get(randomNum).removeAtk(-3);
                    cardPlayed.push("blood on " + player.friendBoard.get(randomNum));

                }

        }
    }

    public void doRathand(int mana) {
        if (player.getBoardSize() <= 7) {
            hand.useMana(mana);
            RatCatcher rat = new RatCatcher();
            player.addMinionPos("rat", rat);
            int random = (int) (Math.random() * player.getBoardSize());
            int hp = player.getMinionName(random).getMinionHealth();
            int attack = player.getMinionName(random).getMinionAttack();
            player.getMinionName(random).dealDamage(500);
            rat.isOnBoard();
            rat.dealDamage(-hp);
            rat.removeAtk(-attack);
            cardPlayed.push("rat on "+ player.friendBoard.get(random) + random);
        }
    }

    public void doRatBoard() {
        if(enemy.enemyBoard.contains("gm") && enemy.getMinionName("gm").isAlive()){
            int pos = player.getMinionPos("rat");
            enemy.getMinionName("gm").dealDamage(player.getMinionName(pos).getMinionAttack());
            player.getMinionName(pos).dealDamage(enemy.getMinionName("gm").getMinionAttack());
            cardPlayed.push("rat on gm");

        }
        else if(enemy.enemBoard.size() > 0){
            int random = (int) (Math.random() * 2 + 1);
            int pos = player.getMinionPos("rat");
            enemy.enemBoard.get(random).dealDamage(player.getMinionName(pos).getMinionAttack());
            player.getMinionName(pos).dealDamage(enemy.enemBoard.get(random).getMinionAttack());
            cardPlayed.push("rat on "+ enemy.enemyBoard.get(random));

        }
    }

    public void doMoat(int mana) {
        if (player.getBoardSize() <= 7) {
            hand.useMana(mana);
            MoatLurker moat = new MoatLurker();
            player.addMinionPos("moat", moat);
            int random = (int) (Math.random() * 2 + 1);
            if(random == 1){
                if(enemy.enemBoard.size() > 0) {
                    int randomNum = (int) (Math.random() * enemy.enemBoard.size() + 1);
                    enemy.enemBoard.get(randomNum - 1).dealDamage(500);
                    cardPlayed.push("moat on " + enemy.enemBoard.get(randomNum - 1));
                    lurk.push(enemy.enemBoard.get(randomNum - 1));
                    lurker = "enemy";
                }
            }
            else {
                if(enemy.enemBoard.size() > 0) {
                    int randomNum = (int) (Math.random() * player.friendBoard.size() + 1);
                    player.friendBoard.get(randomNum - 1).dealDamage(500);
                    cardPlayed.push("moat on " + player.friendBoard.get(randomNum - 1));
                    lurk.push(player.friendBoard.get(randomNum - 1));
                    lurker = "player";
                }
            }
        }
    }

    public void doVoidTerror(int mana) {
        if (player.getBoardSize() <= 7) {
            hand.useMana(mana);
            MoatLurker terror = new MoatLurker();
            player.addMinionPos("terror", terror);
            int pos = player.getMinionPos("terror");
            if (pos == 0) {
                int hp = player.getMinionName(1).getMinionHealth();
                int attack = player.getMinionName(1).getMinionAttack();
                player.getMinionName(1).dealDamage(500);
                terror.dealDamage(-hp);
                terror.removeAtk(-attack);
                cardPlayed.push("terror on pos " + pos);
            } else if (pos == player.getBoardSize() - 1) {
                int hp = player.getMinionName(player.getBoardSize() - 2).getMinionHealth();
                int attack = player.getMinionName(player.getBoardSize() - 2).getMinionAttack();
                player.getMinionName(player.getBoardSize() - 2).dealDamage(500);
                terror.dealDamage(-hp);
                terror.removeAtk(-attack);
                cardPlayed.push("terror on pos " + pos);
            } else {
                int hp = player.getMinionName(player.getMinionPos("terror") - 1).getMinionHealth();
                int attack = player.getMinionName(player.getMinionPos("terror") - 1).getMinionAttack();
                player.getMinionName(player.getMinionPos("terror") - 1).dealDamage(500);
                int hp2 = player.getMinionName(player.getMinionPos("terror") + 1).getMinionHealth();
                int attack2 = player.getMinionName(player.getMinionPos("terror") + 1).getMinionAttack();
                player.getMinionName(player.getMinionPos("terror") + 1).dealDamage(500);
                terror.dealDamage(-hp);
                terror.removeAtk(-attack);
                terror.dealDamage(-hp2);
                terror.removeAtk(-attack2);
                cardPlayed.push("terror on pos " + pos);
            }
        }
    }
}
