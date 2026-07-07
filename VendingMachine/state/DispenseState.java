package state;

import enums.Coin;
import model.Product;
import service.VendingMachine;

/**
 * A product is selected and paid for. dispense() drops the item, returns any
 * change, reduces stock, and resets the machine back to Idle. While in this
 * state we ignore new coins/selections until the current sale finishes.
 */
public class DispenseState implements VendingMachineState {
    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Please wait — dispensing in progress.");
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Please wait — already dispensing.");
    }

    @Override
    public void dispense() {
        Product product = machine.getSelectedProduct();
        int change = machine.getBalance() - product.getPrice();

        machine.getInventory().reduceStock(product.getCode());
        System.out.println("Dispensed: " + product.getName());
        if (change > 0) {
            System.out.println("Returning change: " + change + "c");
        }

        machine.reset();
        machine.setState(machine.getIdleState()); // back to start
    }

    @Override
    public void refund() {
        // Already paid; cancel the sale and give the money back.
        machine.refundBalance();
        machine.reset();
        machine.setState(machine.getIdleState());
    }
}
