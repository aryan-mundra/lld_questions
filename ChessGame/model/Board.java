package model;

import enums.Color;

/**
 * The 8x8 grid. Builds the standard starting position and offers a helper to
 * check whether the straight/diagonal line between two cells is unobstructed
 * (used by the sliding pieces: rook, bishop, queen).
 */
public class Board {
    private final Cell[][] cells = new Cell[8][8];

    public Board() {
        initEmpty();
        setupPieces();
    }

    private void initEmpty() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                cells[r][c] = new Cell(r, c, null);
            }
        }
    }

    private void setupPieces() {
        // White occupies rows 0-1, Black rows 6-7.
        placeBackRank(0, Color.WHITE);
        placeBackRank(7, Color.BLACK);
        for (int c = 0; c < 8; c++) {
            cells[1][c].setPiece(new Pawn(Color.WHITE));
            cells[6][c].setPiece(new Pawn(Color.BLACK));
        }
    }

    private void placeBackRank(int row, Color color) {
        cells[row][0].setPiece(new Rook(color));
        cells[row][1].setPiece(new Knight(color));
        cells[row][2].setPiece(new Bishop(color));
        cells[row][3].setPiece(new Queen(color));
        cells[row][4].setPiece(new King(color));
        cells[row][5].setPiece(new Bishop(color));
        cells[row][6].setPiece(new Knight(color));
        cells[row][7].setPiece(new Rook(color));
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /** True if every square strictly between start and end is empty. */
    public boolean isPathClear(Cell start, Cell end) {
        int dr = Integer.signum(end.getRow() - start.getRow());
        int dc = Integer.signum(end.getCol() - start.getCol());
        int r = start.getRow() + dr;
        int c = start.getCol() + dc;
        while (r != end.getRow() || c != end.getCol()) {
            if (cells[r][c].getPiece() != null) {
                return false;
            }
            r += dr;
            c += dc;
        }
        return true;
    }

    /** Print the board so White is uppercase, Black lowercase, '.' is empty. */
    public void print() {
        for (int r = 7; r >= 0; r--) {
            StringBuilder sb = new StringBuilder((r + 1) + "  ");
            for (int c = 0; c < 8; c++) {
                Piece p = cells[r][c].getPiece();
                if (p == null) {
                    sb.append(". ");
                } else {
                    char s = p.getSymbol();
                    sb.append(p.getColor() == Color.WHITE ? s : Character.toLowerCase(s)).append(' ');
                }
            }
            System.out.println(sb);
        }
        System.out.println("   a b c d e f g h");
    }
}
