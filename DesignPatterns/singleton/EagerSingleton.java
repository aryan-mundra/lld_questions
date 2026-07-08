/**
 * EAGER singleton: the single instance is created when the class loads.
 * + Simple and inherently thread-safe (created once by the JVM).
 * - Created even if you never actually use it (wastes resources if heavy).
 */
public class EagerSingleton {
    // created immediately, at class-load time
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() { }              // private -> nobody else can 'new' it

    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    public void hello() {
        System.out.println("Eager singleton, id=" + System.identityHashCode(this));
    }
}
