package model;

import enums.Color;

public class Knight extends Piece {
    public Knight(Color color) { super(color); }

    @Override
    public boolean canMove(Board board, Cell start, Cell end) {
        int dr = Math.abs(end.getRow() - start.getRow());
        int dc = Math.abs(end.getCol() - start.getCol());
        // the "L" shape; a knight jumps, so no path check needed
        return (dr == 2 && dc == 1) || (dr == 1 && dc == 2);
    }

    @Override
    public char getSymbol() { return 'N'; }
}
