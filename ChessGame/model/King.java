package model;

import enums.Color;

public class King extends Piece {
    public King(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int dr = Math.abs(end.getRow() - start.getRow());
        int dc = Math.abs(end.getCol() - start.getCol());
        // one square in any direction (and not standing still)
        return (dr <= 1 && dc <= 1) && (dr + dc != 0);
    }

    @Override
    public char getSymbol() { return 'K'; }
}
