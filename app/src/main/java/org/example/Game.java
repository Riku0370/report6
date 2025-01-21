package org.example;

import java.util.Scanner;
import java.util.Random;


public class Game {
    private Board board;
    private String playerStone;  // 現在のプレイヤー（'⚫️' = 黒, '○' = 白）
    private boolean gameOver;

    public Game() {
        board = new Board();
        playerStone = board.getBlack();  // 初めは黒からスタート
        gameOver = false;
    }

    // ゲームの進行
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("現在のプレイヤーは" + playerStone + "です");
            board.display();

            int row, col;

            // プレイヤーがランダムで手を打つ場合
            if (playerStone.equals("○")) {
                // AI（白のプレイヤー）のランダムプレイ
                Random random = new Random();
                do {
                    row = random.nextInt(8);  // 0〜7の間でランダムに行
                    col = random.nextInt(8);  // 0〜7の間でランダムに列
                } while (!board.pieces(row, col, playerStone));  // 無効な場所なら再試行
                System.out.println("AI（白）が置いた場所: " + row + ", " + col);
            } else {
                // プレイヤー（黒）が手を打つ場合
                System.out.print("置きたい行を選択してください（0〜7）: ");
                row = scanner.nextInt();
                System.out.print("置きたい列を選択してください（0〜7）: ");
                col = scanner.nextInt();
                if (!board.pieces(row, col, playerStone)) {
                    System.out.println("無効な場所です。もう一度試してください。");
                    continue;  // 無効な場所なら次のループへ
                }
            }

            board.display();

            if (board.isGameover()) {
                gameOver = true;
                board.winner();
            } else {
                switchTurn();
            }
        }
        scanner.close();
    }

    // プレイヤーのターンを切り替え
    private void switchTurn() {
        if (playerStone.equals("⚫️")) {
            playerStone = "○";  // 次は白（AIのターン）
        } else {
            playerStone = "⚫️";  // 次は黒（プレイヤーのターン）
        }
    }
}