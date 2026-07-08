package model;

import enums.Color;

public class Bishop extends Piece {
    public Bishop(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int dr = Math.abs(end.getRow() - start.getRow());
        int dc = Math.abs(end.getCol() - start.getCol());
        // diagonal only (equal row/col distance, non-zero)...
        if (dr != dc || dr == 0) {
            return false;
        }
        // ...with a clear diagonal
        return board.isPathClear(start, end);
    }

    @Override
    public char getSymbol() { return 'B'; }
}
