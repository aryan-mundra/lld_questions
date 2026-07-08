import service.LRUCache;

/**
 * Demo: a capacity-3 cache. Watch how accessing a key refreshes its recency,
 * and how a new insert into a full cache evicts the least-recently-used entry.
 */
public class Main {
    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "A"); System.out.println("put(1,A)  " + cache.snapshot());
        cache.put(2, "B"); System.out.println("put(2,B)  " + cache.snapshot());
        cache.put(3, "C"); System.out.println("put(3,C)  " + cache.snapshot());

        System.out.println("get(1) = " + cache.get(1) + "   " + cache.snapshot()); // touch 1

        cache.put(4, "D"); System.out.println("put(4,D)  " + cache.snapshot());    // evicts LRU (2)

        System.out.println("get(2) = " + cache.get(2)); // null — 2 was evicted
        System.out.println("get(4) = " + cache.get(4)); // D
    }
}
