import org.example.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.display(); // 盤面を表示
        
        // 石を置いてみる
        board.pieces(2, 3, board.getBlack()); // 黒の石を置く
        board.display(); // 盤面を表示
        board.winnar();

    }
}
