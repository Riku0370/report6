package org.example;

import org.checkerframework.checker.units.qual.s;

public class Board {
    private String black = "⚫️";
    private String white = "○";
    private String blank = "・";
    private String[][] stage = new String[8][8];
    private final int size = 8;

    
    public Board() {
        resetting();
        
    }

    public String getBlack(){
        return black;
    }
    
    public String getWhite(){
        return white;
    }

    //盤面の初期化
    public void resetting() {
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                stage[i][k] = blank;

            }
        }
        stage[3][3] = black;
        stage[3][4] = white;
        stage[4][3] = white;
        stage[4][4] = black;
    }

    //盤面の表示
    public void display(){
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                System.out.println(stage[i][k]);
            }
        }
    }

    //駒をおく
    public boolean pieces(int row, int col, String stone){
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

    //勝利したチーム
    public void winnar(){
        int blackcount = 0;
        int whitecount = 0;
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                if (stage[i][k] == black) {
                    blackcount ++;
                }
                if (stage[i][k] == white) {
                    whitecount ++ ;
                }
            }
        }
        System.err.println("盤面の黒の数は" + blackcount + "、盤面の白の数は" + whitecount);
        if (whitecount > blackcount) {
            System.out.println("勝者は白！");
        }else if(blackcount > whitecount){
            System.out.println("勝者は黒！");
        }else if(blackcount == whitecount){
            System.out.println("両者引き分け");
        }
    }

    //新しいゲームの設定
    public void resetBoard() {
        resetting();
    }

    //ゲームの終了判定
    public boolean Gameover(){
        for (int i = 0; i < size; i++){
            for (int k = 0; k < size; k++){
                if (stage[i][k] == blank) {
                    return false;
                }
            }
        }
        return true;
    }
}


