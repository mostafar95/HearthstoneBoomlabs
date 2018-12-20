package playGame;

import EnemyMinions.*;
import FriendlyMinions.*;

import java.util.Stack;

public class RunSimulation {
    FriendlyBoard player = new FriendlyBoard();
    EnemyBoard enemy = new EnemyBoard();
    FriendlyHand hand = new FriendlyHand();
    doTurns doturn = new doTurns();

    Stack thisCard = new Stack();

    public static void main(String[] args) {
        RunSimulation rm = new RunSimulation();
    }

    private RunSimulation() {
        //player.startofGame();
        //enemy.startofGame();
        startofgame();
        int counter = 0;

        while (player.friendBoard.size() != 0 && enemy.enemBoard.size() != 0) {
            int handsize = hand.hand.size();
            int playerminionsize = player.friendBoard.size();
            int enemyminionsize = enemy.enemBoard.size();
            if(hand.hand.size() == 0){
                enemy.enemBoard.clear();
                enemy.enemyBoard.clear();
                hand.hand.clear();
                player.friendlyBoard.clear();
                player.friendBoard.clear();
                startofgame();
                hand.setMana(70);
                counter = 0;
            }
            doturn.deadMinions.clear();
            int playersize = player.friendBoard.size();
            int enemysize = enemy.enemBoard.size();
            int randomNum = (int) (Math.random() * hand.hand.size());
            thisCard.push(hand.hand.get(randomNum));
            if (hand.hand.get(randomNum) == "defile") {
                if ((player.friendBoard.contains(player.sorce) && !player.friendBoard.contains(player.sorce2)) || (!player.friendBoard.contains(player.sorce) && player.friendBoard.contains(player.sorce2))) {
                    if (hand.getPlayerMana() >= 1) {//med en aprentice ilive
                        hand.hand.remove(randomNum);
                        doturn.doDefile(1);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else if (!player.friendBoard.contains(player.sorce2) && !player.friendBoard.contains(player.sorce)) {
                    if (hand.getPlayerMana() >= 2) {//med 2 døde aprentice
                        hand.hand.remove(randomNum);
                        doturn.doDefile(2);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else {//begge i live
                    hand.hand.remove(randomNum);
                    doturn.doDefile(0);
                    if (player.friendlyBoard.contains("wp")) {
                        for (int i = 0; i < enemy.enemBoard.size(); i++) {
                            enemy.enemBoard.get(i).dealDamage(1);
                        }
                        for (int i = 0; i < player.friendBoard.size(); i++) {
                            player.friendBoard.get(i).dealDamage(1);
                        }
                    }
                    if (player.friendlyBoard.contains("arcane")) {
                        int pos = player.getMinionPos("arcane");
                        player.getMinionName(pos).dealDamage(-1);
                    }
                }
            }
            if (thisCard.peek() == "deamon") {
                if ((player.friendBoard.contains(player.sorce) && !player.friendBoard.contains(player.sorce2)) || (!player.friendBoard.contains(player.sorce) && player.friendBoard.contains(player.sorce2))) {
                    if (hand.getPlayerMana() >= 1) {//med en aprentice ilive
                        hand.hand.remove(randomNum);
                        doturn.doDeamonFire(1);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else if (!player.friendBoard.contains(player.sorce2) && !player.friendBoard.contains(player.sorce)) {
                    if (hand.getPlayerMana() >= 2) {//med 2 døde aprentice
                        hand.hand.remove(randomNum-1);
                        doturn.doDeamonFire(2);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else {//begge i live
                    hand.hand.remove(randomNum);
                    doturn.doDeamonFire(0);
                    if (player.friendlyBoard.contains("wp")) {
                        for (int i = 0; i < enemy.enemBoard.size(); i++) {
                            enemy.enemBoard.get(i).dealDamage(1);
                        }
                        for (int i = 0; i < player.friendBoard.size(); i++) {
                            player.friendBoard.get(i).dealDamage(1);
                        }
                    }
                    if (player.friendlyBoard.contains("arcane")) {
                        int pos = player.getMinionPos("arcane");
                        player.getMinionName(pos).dealDamage(-1);
                    }
                }
            }

            if (thisCard.peek() == "deamon") {
                if ((player.friendBoard.contains(player.sorce) && !player.friendBoard.contains(player.sorce2)) || (!player.friendBoard.contains(player.sorce) && player.friendBoard.contains(player.sorce2))) {
                    if (hand.getPlayerMana() >= 2) {//med en aprentice ilive
                        hand.hand.remove(randomNum);
                        doturn.doBloodFurry(2);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else if (!player.friendBoard.contains(player.sorce2) && !player.friendBoard.contains(player.sorce)) {
                    if (hand.getPlayerMana() >= 3) {//med 2 døde aprentice
                        hand.hand.remove(randomNum-1);
                        doturn.doDeamonFire(3);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                } else {//begge i live
                    if (hand.getPlayerMana() >= 1) {//med 2 døde aprentice
                        hand.hand.remove(randomNum);
                        doturn.doDeamonFire(1);
                        if (player.friendlyBoard.contains("wp")) {
                            for (int i = 0; i < enemy.enemBoard.size(); i++) {
                                enemy.enemBoard.get(i).dealDamage(1);
                            }
                            for (int i = 0; i < player.friendBoard.size(); i++) {
                                player.friendBoard.get(i).dealDamage(1);
                            }
                        }
                        if (player.friendlyBoard.contains("arcane")) {
                            int pos = player.getMinionPos("arcane");
                            player.getMinionName(pos).dealDamage(-1);
                        }
                    } else {
                        break;
                    }
                }
            }

            //if playing a minion while summoning portal is open
            if (thisCard.peek() == "rat" && hand.rat.isOnBoard()) {
                if (player.friendBoard.contains(player.sp)) {
                    if (hand.getPlayerMana() >= 1) {
                        hand.hand.remove(randomNum);
                        doturn.doRathand(1);
                    } else {
                        if(hand.getPlayerMana() >= 3) {
                            hand.hand.remove(randomNum-1);
                            doturn.doRathand(3);
                        }
                    }
                }
            } else if (thisCard.peek() == "rat") {
                hand.hand.remove(randomNum);
                doturn.doRatBoard();
            }
            if (thisCard.peek() == "void" && player.friendBoard.contains(player.sp) && hand.getPlayerMana() >= 1) {
                hand.hand.remove(randomNum);
                doturn.doVoidTerror(1);
            } else if (thisCard.peek() == "void" && hand.getPlayerMana() >= 3) {
                hand.hand.remove(randomNum);
                doturn.doVoidTerror(3);
            }
            if (thisCard.peek() == "moat" && player.friendBoard.contains(player.sp) && hand.getPlayerMana() >= 4) {
                hand.hand.remove(randomNum);
                doturn.doMoat(4);
            }
            if (thisCard.peek() == "moat" && hand.getPlayerMana() >= 6) {
                hand.hand.remove(randomNum);
                doturn.doMoat(6);
            }
            if (thisCard.peek() == "arcane" && hand.getPlayerMana() >= 1) {
                hand.hand.remove(randomNum);
                doturn.doArcane(1);
            }
            counter++;
            if (counter == 10) {
                enemy.enemBoard.clear();
                enemy.enemyBoard.clear();
                hand.hand.clear();
                player.friendlyBoard.clear();
                player.friendBoard.clear();
                hand.setMana(70);
                startofgame();
                counter = 0;
            }
            if (doturn.deadMinions.contains("storm")) {
                for (int i = 0; i < enemy.enemyBoard.size(); i++) {
                    if (enemy.enemBoard.get(i).getMinionHealth() > 1) {
                        enemy.enemBoard.get(i).dealDamage(1);
                        enemy.enemBoard.get(i).removeAtk(1);
                    }
                }
            }
            if (doturn.deadMinions.contains("moat")) {
                Object newmin = doturn.lurk.pop();
                if(newmin == "enemy"){
                    int randomInt = (int) (Math.random() * enemy.getBoardSize());
                    enemy.enemyBoard.get(randomNum);
                }
                else {
                    int randomInt = (int) (Math.random() * player.friendBoard.size());
                    player.friendBoard.get(randomNum);
                }
            }
            player.doTurn();
            enemy.doTurn();
            thisCard.clear();
        }
        while (!doturn.cardPlayed.empty()) {
            System.out.println(doturn.cardPlayed.pop());
        }
    }

    private void startofgame(){
        enemy.enemyBoard.add("storm");
        enemy.enemyBoard.add("tyrantus");
        enemy.enemyBoard.add("gm");
        enemy.enemyBoard.add("ultra");
        enemy.enemyBoard.add("sg");
        enemy.enemyBoard.add("kuun");
        enemy.enemyBoard.add("jg");

        StormwindChampion storm = new StormwindChampion();
        Tyrantus tyrantus = new Tyrantus();
        GiantMastodon gm = new GiantMastodon();
        Ultrasaur ultra = new Ultrasaur();
        Seagiand sg = new Seagiand();
        Kuun kuun = new Kuun();
        JadeGolem jg = new JadeGolem();

        enemy.enemBoard.add(storm);
        enemy.enemBoard.add(tyrantus);
        enemy.enemBoard.add(gm);
        enemy.enemBoard.add(ultra);
        enemy.enemBoard.add(sg);
        enemy.enemBoard.add(kuun);
        enemy.enemBoard.add(jg);

        player.friendlyBoard.add("sorce");
        player.friendlyBoard.add("wp");
        player.friendlyBoard.add("sorce2");
        player.friendlyBoard.add("fd");
        player.friendlyBoard.add("sp");

        SorcressAprentice sorce = new SorcressAprentice();
        WildPyromancer wp = new WildPyromancer();
        SorcressAprentice sorce2 = new SorcressAprentice();
        FearsomeDoomguard fd = new FearsomeDoomguard();
        SummoningPortal sp = new SummoningPortal();

        player.friendBoard.add(player.sorce);
        player.friendBoard.add(player.wp);
        player.friendBoard.add(player.sorce2);
        player.friendBoard.add(player.fd);
        player.friendBoard.add(player.sp);

        hand.hand.add("arcane");
        hand.hand.add("blood");
        hand.hand.add("blood");
        hand.hand.add("deamon");
        hand.hand.add("deamon");
        hand.hand.add("defile");
        hand.hand.add("moat");
        hand.hand.add("rat");
        hand.hand.add("voidterror");
    }
    /**
     * TODO: Skjer noe rart med at store minions aldri dør og små minions aldr kommer tilbake
     */
}
