package service;

import enums.Coin;
import model.Inventory;
import model.Product;
import state.DispenseState;
import state.HasMoneyState;
import state.IdleState;
import state.VendingMachineState;

/**
 * The CONTEXT in the State pattern. It holds one instance of each state and a
 * pointer to the current one, then simply DELEGATES every user action to that
 * current state. The states themselves decide behavior and transitions, so this
 * class has no big if/switch on "what mode am I in".
 */
public class VendingMachine {
    private final VendingMachineState idleState;
    private final VendingMachineState hasMoneyState;
    private final VendingMachineState dispenseState;

    private VendingMachineState currentState;

    private final Inventory inventory = new Inventory();
    private int balance = 0;
    private Product selectedProduct;

    public VendingMachine() {
        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispenseState = new DispenseState(this);
        currentState = idleState;
    }

    // --- user actions: just delegate to the current state ---
    public void insertCoin(Coin coin) { currentState.insertCoin(coin); }
    public void selectProduct(String code) { currentState.selectProduct(code); }
    public void dispense() { currentState.dispense(); }
    public void refund() { currentState.refund(); }

    // --- state management ---
    public void setState(VendingMachineState state) { this.currentState = state; }
    public VendingMachineState getIdleState() { return idleState; }
    public VendingMachineState getHasMoneyState() { return hasMoneyState; }
    public VendingMachineState getDispenseState() { return dispenseState; }

    // --- helpers the states use ---
    public void addBalance(int amount) { this.balance += amount; }
    public int getBalance() { return balance; }

    public void refundBalance() {
        if (balance > 0) {
            System.out.println("Refunding " + balance + "c");
        }
        balance = 0;
    }

    public void reset() {
        balance = 0;
        selectedProduct = null;
    }

    public Inventory getInventory() { return inventory; }
    public Product getSelectedProduct() { return selectedProduct; }
    public void setSelectedProduct(Product product) { this.selectedProduct = product; }
}
