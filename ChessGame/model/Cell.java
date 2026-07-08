package model;

/**
 * One square on the board. Knows its coordinates and which piece (if any)
 * currently sits on it. A null piece means the square is empty.
 */
public class Cell {
    private final int row;
    private final int col;
    private Piece piece;

    public Cell(int row, int col, Piece piece) {
        this.row = row;
        this.col = col;
        this.piece = piece;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public Piece getPiece() { return piece; }
    public void setPiece(Piece piece) { this.piece = piece; }
}
