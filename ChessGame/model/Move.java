package model;

/**
 * A record of one move: who moved, from where to where, which piece moved and
 * which (if any) was captured. Useful for history, undo, and notation.
 */
public class Move {
    private final Player player;
    private final Cell start;
    private final Cell end;
    private final Piece pieceMoved;
    private final Piece pieceCaptured;

    public Move(Player player, Cell start, Cell end, Piece pieceMoved, Piece pieceCaptured) {
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = pieceMoved;
        this.pieceCaptured = pieceCaptured;
    }

    public Player getPlayer() { return player; }
    public Cell getStart() { return start; }
    public Cell getEnd() { return end; }
    public Piece getPieceMoved() { return pieceMoved; }
    public Piece getPieceCaptured() { return pieceCaptured; }
}
