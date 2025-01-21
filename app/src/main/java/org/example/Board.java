package org.example;

public class Board {
    private String black = "⚫️";
    private String white = "○";
    private String blank = "・";
    private String[][] stage = new String[8][8];
    private final int size = 8;

    public int getSize(){
        return size;
    }

    public Board() {
        resetting();
    }

    public String getBlack(){
        return black;
    }

    public String getWhite(){
        return white;
    }

    public String getBlank(){
        return blank;
    }

    // 盤面の初期化
    public void resetting() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                stage[i][k] = blank;
            }
        }
        stage[3][3] = black;
        stage[3][4] = white;
        stage[4][3] = white;
        stage[4][4] = black;
    }

    // 盤面の表示
    public void display() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                System.out.print(stage[i][k] + " ");  // 横並びで表示
            }
            System.out.println();  // 行が終わったら改行
        }
    }

    // 駒を置く
    public boolean pieces(int row, int col, String stone) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            System.out.println("無効な座標です！");
            return false;
        }
        if (stage[row][col] != blank) {
            System.out.println("この場所には石を置けません！");
            return false;
        }
        stage[row][col] = stone;  // 石を置く
        return true;
    }

    // 駒を置けるかの判定
    public boolean hantei() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (stage[i][k] == blank) {  // 空いている場所があれば、置ける場所がある
                    return true;
                }
            }
        }
        return false;  // 空いている場所がなければ、置けない
    }

    // 勝利したチーム
    public void winner() {  
        int blackCount = 0;
        int whiteCount = 0;
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (stage[i][k].equals(black)) {
                    blackCount++;
                }
                if (stage[i][k].equals(white)) {
                    whiteCount++;
                }
            }
        }
        System.out.println("盤面の黒の数は" + blackCount + "、盤面の白の数は" + whiteCount);
        if (whiteCount > blackCount) {
            System.out.println("勝者は白！");
        } else if (blackCount > whiteCount) {
            System.out.println("勝者は黒！");
        } else {
            System.out.println("両者引き分け");
        }
    }

    // ゲームの終了判定
    public boolean isGameover() {
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (stage[i][k] == blank) {
                    return false;
                }
            }
        }
        return true;
    }
}