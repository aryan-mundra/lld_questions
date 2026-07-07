package state;

import enums.Coin;
import model.Product;
import service.VendingMachine;

/**
 * Money has been inserted. The user can add more coins, ask for a refund,
 * or select a product. A valid selection (in stock + enough money) moves us
 * to the dispensing state.
 */
public class HasMoneyState implements VendingMachineState {
    private final VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin(Coin coin) {
        machine.addBalance(coin.getValue());
        System.out.println("Inserted " + coin + " -> balance = " + machine.getBalance() + "c");
    }

    @Override
    public void selectProduct(String code) {
        if (!machine.getInventory().isAvailable(code)) {
            System.out.println("Sorry, " + code + " is out of stock.");
            return;
        }
        Product product = machine.getInventory().getProduct(code);
        if (machine.getBalance() < product.getPrice()) {
            System.out.println("Insufficient balance for " + product.getName()
                    + ". Need " + product.getPrice() + "c, have " + machine.getBalance() + "c.");
            return;
        }
        machine.setSelectedProduct(product);
        System.out.println("Selected " + product.getName() + " (" + product.getPrice() + "c).");
        machine.setState(machine.getDispenseState()); // transition
    }

    @Override
    public void dispense() {
        System.out.println("Please select a product first.");
    }

    @Override
    public void refund() {
        machine.refundBalance();
        machine.setState(machine.getIdleState());
    }
}
