import enums.Color;
import model.Player;
import service.ChessGame;

/**
 * Demo: set up a game and play a few moves — including a capture and a couple
 * of illegal attempts — to show the validation and turn handling in action.
 * Coordinates are (row, col) with White on rows 0-1, Black on rows 6-7.
 */
public class Main {
    public static void main(String[] args) {
        Player white = new Player("Alice", Color.WHITE);
        Player black = new Player("Bob", Color.BLACK);
        ChessGame game = new ChessGame(white, black);

        System.out.println("Starting position:");
        game.getBoard().print();
        System.out.println();

        game.makeMove(white, 1, 4, 3, 4); // 1. e2-e4  (white pawn, two squares)
        game.makeMove(black, 6, 3, 4, 3); // 2. d7-d5  (black pawn, two squares)
        game.makeMove(white, 3, 4, 4, 3); // 3. e4xd5  (white pawn captures diagonally)

        game.makeMove(white, 1, 0, 2, 0); // out of turn -> rejected (it's Black's move)
        game.makeMove(black, 7, 1, 5, 2); // 4. Nb8-c6 (black knight)

        game.makeMove(white, 0, 0, 3, 0); // illegal -> rook a1 is blocked by its own pawn
        game.makeMove(white, 0, 6, 2, 5); // 5. Ng1-f3 (legal knight jump)

        System.out.println("\nBoard now:");
        game.getBoard().print();
    }
}
