package state;

import enums.Coin;

/**
 * The State pattern's contract. The machine behaves differently depending on
 * which state it's in, so every state must handle the same four user actions.
 * Each concrete state decides what each action does (and when to switch state).
 */
public interface VendingMachineState {
    void insertCoin(Coin coin);
    void selectProduct(String code);
    void dispense();
    void refund();
}
