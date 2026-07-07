import enums.Coin;
import model.Product;
import service.VendingMachine;

/**
 * Demo: stock the machine, then run a few scenarios to show the state
 * transitions (idle -> has money -> dispensing -> idle) in action.
 */
public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.getInventory().addProduct(new Product("A1", "Coke", 125), 2);
        machine.getInventory().addProduct(new Product("A2", "Water", 75), 1);

        System.out.println("--- Buy a Coke (125c) with exact change ---");
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER); // 125c
        machine.selectProduct("A1");
        machine.dispense();

        System.out.println("\n--- Buy a Water (75c), overpay by 25c ---");
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER);
        machine.insertCoin(Coin.QUARTER); // 100c
        machine.selectProduct("A2");
        machine.dispense(); // returns 25c change

        System.out.println("\n--- Try Water again: now out of stock ---");
        machine.insertCoin(Coin.QUARTER);
        machine.selectProduct("A2");
        machine.refund(); // give the money back
    }
}
