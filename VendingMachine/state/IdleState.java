package state;

import enums.Coin;
import service.VendingMachine;

/**
 * Starting state: no money inserted yet.
 * The only meaningful action is inserting a coin, which moves us forward.
 */
public class IdleState implements VendingMachineState {
    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Inserted " + coin + " -> balance = " + machine.getBalance() + "c");
        machine.setState(machine.getHasMoneyState()); // transition
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Please insert money first.");
    }

    @Override
    public void dispense() {
        System.out.println("Insert money and select a product first.");
    }

    @Override
    public void refund() {
        System.out.println("No money to refund.");
    }
}
