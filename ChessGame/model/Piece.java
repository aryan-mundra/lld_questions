package model;

import enums.Color;

/**
 * Base class for every chess piece. It's abstract because a generic "piece"
 * has no meaning — only real pieces (King, Rook, …) exist. Each subclass
 * encapsulates its OWN movement rule by overriding canMove(). That's the key
 * design idea: the game never asks "what type is this?" — it just asks the
 * piece whether the move is legal (polymorphism).
 */
public abstract class Piece {
    private final Color color;
    private boolean killed = false;

    protected Piece(Color color) {
        this.color = color;
    }

    public Color getColor() { return color; }
    public boolean isKilled() { return killed; }
    public void setKilled(boolean killed) { this.killed = killed; }

    /** Can this piece legally move from start to end on this board? */
    public abstract boolean canMove(Board board, Cell start, Cell end);

    /** One-letter symbol (K, Q, R, B, N, P) used for printing the board. */
    public abstract char getSymbol();
}
