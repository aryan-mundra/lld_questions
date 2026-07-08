/**
 * LAZY singleton: the instance is created only on the first getInstance() call.
 * + Not created until needed (saves resources).
 * - Needs care with threads. 'synchronized' makes this version thread-safe.
 */
public class LazySingleton {
    private static LazySingleton instance;   // not created yet (null)

    private LazySingleton() { }

    // synchronized: two threads can't both slip in and create two instances
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {              // create on first use only
            instance = new LazySingleton();
        }
        return instance;
    }

    public void hello() {
        System.out.println("Lazy singleton, id=" + System.identityHashCode(this));
    }
}
