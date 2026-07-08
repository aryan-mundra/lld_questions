public class Main {
    public static void main(String[] args) {
        EagerSingleton e1 = EagerSingleton.getInstance();
        EagerSingleton e2 = EagerSingleton.getInstance();
        System.out.println("Same eager instance? " + (e1 == e2)); // true
        e1.hello();

        LazySingleton l1 = LazySingleton.getInstance();
        LazySingleton l2 = LazySingleton.getInstance();
        System.out.println("Same lazy instance?  " + (l1 == l2)); // true
        l1.hello();
    }
}
