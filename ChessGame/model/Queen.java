package model;

import enums.Color;

public class Queen extends Piece {
    public Queen(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int dr = Math.abs(end.getRow() - start.getRow());
        int dc = Math.abs(end.getCol() - start.getCol());
        boolean straight = (start.getRow() == end.getRow() || start.getCol() == end.getCol());
        boolean diagonal = (dr == dc);
        // queen = rook + bishop; must actually move and have a clear path
        if ((!straight && !diagonal) || (dr + dc == 0)) {
            return false;
        }
        return board.isPathClear(start, end);
    }

    @Override
    public char getSymbol() { return 'Q'; }
}
