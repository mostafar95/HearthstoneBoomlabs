package tests;

import FriendlyHand.VoidTerror;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import playGame.FriendlyBoard;
import java.lang.Object;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerBoardTest {
    VoidTerror vt = new VoidTerror();
    VoidTerror vt2 = new VoidTerror();
    VoidTerror vt3 = new VoidTerror();
    FriendlyBoard player = new FriendlyBoard();
    @Test
    void sanityTest() {
        player.startofGame();
        assertEquals(5, player.friendBoard.size());
        assertEquals(5, player.getBoardSize());
        player.addMinionPos("minion", vt);
        assertEquals(6, player.getBoardSize());
        player.addMinionPos("minionenenee", vt2);
        assertEquals(7, player.getBoardSize());
        player.addMinionPos("ikkedenne", vt3);
        assertEquals(7, player.getBoardSize());
        player.removeMinion("minion");
        assertEquals(6, player.getBoardSize());
        player.removeMinion("minionenenee");
        player.removeMinion("sorce");
        player.removeMinion("wp");
        player.removeMinion("sorce2");
        player.removeMinion("fd");
        player.removeMinion("sp");
        assertEquals(0, player.getBoardSize());
        player.removeMinion(" dfgfdg");
        assertEquals(0, player.getBoardSize());
        player.startofGame();
        assertEquals(5, player.friendlyBoard.size());
        player.friendBoard.clear();
        player.friendlyBoard.clear();
        assertEquals(0, player.friendlyBoard.size());


        System.out.println("Venlig brett adder og remover riktig");
    }
}