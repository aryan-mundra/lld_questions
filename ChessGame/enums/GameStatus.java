package enums;

/**
 * Where the game stands. Basic version: a side wins by capturing the enemy
 * king. (Real chess ends on checkmate/stalemate — noted as an extension.)
 */
public enum GameStatus {
    ACTIVE,
    WHITE_WON,
    BLACK_WON
}
