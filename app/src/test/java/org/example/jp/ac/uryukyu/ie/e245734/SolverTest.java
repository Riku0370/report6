package org.example.jp.ac.uryukyu.ie.e245734;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class SolverTest {
    private Game game;
    

    @BeforeEach
    void setUp() {
        game = new Game(); // 新しいゲームのインスタンスを作成
    }

    @Test
    void testSwitchTurn() {
        // 黒からスタート
        assertEquals("⚫️", game.getPlayerStone());
        game.switchTurn();
        assertEquals("○", game.getPlayerStone());  // 1ターン後に白に切り替わる
    }

    
}