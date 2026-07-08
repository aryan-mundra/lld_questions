package model;

import enums.Color;

public class Rook extends Piece {
    public Rook(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        // straight line only...
        if (start.getRow() != end.getRow() && start.getCol() != end.getCol()) {
            return false;
        }
        // ...with nothing in between
        return board.isPathClear(start, end);
    }

    @Override
    public char getSymbol() { return 'R'; }
}
