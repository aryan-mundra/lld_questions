package model;

import enums.Color;

/**
 * Pawns are the fiddly piece: they move forward but capture diagonally, and
 * may advance two squares from their starting rank. "Forward" depends on color
 * (white moves toward higher rows, black toward lower). En passant and
 * promotion are left out of this basic version.
 */
public class Pawn extends Piece {
    public Pawn(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int direction = getColor() == Color.WHITE ? 1 : -1;
        int startRank = getColor() == Color.WHITE ? 1 : 6;
        int dr = end.getRow() - start.getRow();
        int dc = end.getCol() - start.getCol();
        Piece target = end.getPiece();

        // one step forward onto an empty square
        if (dc == 0 && dr == direction && target == null) {
            return true;
        }
        // two steps forward from the starting rank, both squares empty
        if (dc == 0 && dr == 2 * direction && start.getRow() == startRank && target == null
                && board.getCell(start.getRow() + direction, start.getCol()).getPiece() == null) {
            return true;
        }
        // diagonal capture (an enemy piece must be there)
        if (Math.abs(dc) == 1 && dr == direction && target != null) {
            return true;
        }
        return false;
    }

    @Override
    public char getSymbol() { return 'P'; }
}
