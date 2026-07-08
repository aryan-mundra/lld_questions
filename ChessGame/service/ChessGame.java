package service;

import java.util.ArrayList;
import java.util.List;

import enums.Color;
import enums.GameStatus;
import model.Board;
import model.Cell;
import model.King;
import model.Move;
import model.Piece;
import model.Player;

/**
 * The controller / facade. Owns the board, the two players, whose turn it is,
 * and the status. makeMove() is the single entry point: it validates a move
 * (right turn, right piece, not onto your own piece, and the piece's own rule),
 * then applies it, handles capture, and switches the turn.
 */
public class ChessGame {
    private final Board board = new Board();
    private final Player white;
    private final Player black;
    private final List<Move> moves = new ArrayList<>();

    private Player currentTurn;
    private GameStatus status = GameStatus.ACTIVE;

    public ChessGame(Player white, Player black) {
        this.white = white;
        this.black = black;
        this.currentTurn = white; // White always starts
    }

    public boolean makeMove(Player player, int sr, int sc, int er, int ec) {
        if (status != GameStatus.ACTIVE) {
            return reject("game is already over");
        }
        if (player != currentTurn) {
            return reject(player.getName() + " — it's not your turn");
        }

        Cell start = board.getCell(sr, sc);
        Cell end = board.getCell(er, ec);
        Piece moving = start.getPiece();

        if (moving == null) {
            return reject("no piece on the start square");
        }
        if (moving.getColor() != player.getColor()) {
            return reject("that's not your piece");
        }
        Piece target = end.getPiece();
        if (target != null && target.getColor() == player.getColor()) {
            return reject("can't capture your own piece");
        }
        if (!moving.canMove(board, start, end)) {
            return reject("illegal move for that piece");
        }

        // --- apply the move ---
        if (target != null) {
            target.setKilled(true);
            if (target instanceof King) { // basic win condition
                status = (player.getColor() == Color.WHITE) ? GameStatus.WHITE_WON : GameStatus.BLACK_WON;
            }
        }
        end.setPiece(moving);
        start.setPiece(null);
        moves.add(new Move(player, start, end, moving, target));

        System.out.println(player.getName() + " moved " + moving.getSymbol()
                + " " + coord(sr, sc) + " -> " + coord(er, ec)
                + (target != null ? " (captured " + target.getSymbol() + ")" : ""));

        if (status != GameStatus.ACTIVE) {
            System.out.println(">>> " + status);
            return true;
        }
        currentTurn = (currentTurn == white) ? black : white;
        return true;
    }

    private boolean reject(String reason) {
        System.out.println("  ✗ rejected: " + reason);
        return false;
    }

    private String coord(int r, int c) {
        return "" + (char) ('a' + c) + (r + 1);
    }

    public Board getBoard() { return board; }
    public GameStatus getStatus() { return status; }
    public Player getWhite() { return white; }
    public Player getBlack() { return black; }
}
