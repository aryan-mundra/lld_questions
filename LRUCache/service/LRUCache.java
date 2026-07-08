package service;

import java.util.HashMap;
import java.util.Map;

import model.Node;

/**
 * A fixed-capacity Least-Recently-Used cache with O(1) get and put.
 *
 * Two structures working together:
 *   1. HashMap<K, Node>  -> find any key's node in O(1).
 *   2. Doubly linked list -> keep nodes ordered by recency and move/remove
 *      any node in O(1) (just pointer swaps). Front = most recently used (MRU),
 *      back = least recently used (LRU).
 *
 * Dummy head & tail sentinels remove all the null/edge checks.
 */
public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map = new HashMap<>();
    private final Node<K, V> head; // sentinel: head.next is the MRU node
    private final Node<K, V> tail; // sentinel: tail.prev is the LRU node

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    /** Return the value (and mark it most-recently-used), or null on a miss. */
    public V get(K key) {
        Node<K, V> node = map.get(key);
        if (node == null) {
            return null; // miss
        }
        moveToFront(node); // touched -> now most recently used
        return node.value;
    }

    /** Insert or update; evict the least-recently-used entry if full. */
    public void put(K key, V value) {
        Node<K, V> existing = map.get(key);
        if (existing != null) {
            existing.value = value;
            moveToFront(existing);
            return;
        }
        if (map.size() == capacity) {
            evictLeastRecentlyUsed();
        }
        Node<K, V> node = new Node<>(key, value);
        map.put(key, node);
        addToFront(node);
    }

    // ---- doubly linked list helpers, all O(1) ----
    private void addToFront(Node<K, V> node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node<K, V> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToFront(Node<K, V> node) {
        remove(node);
        addToFront(node);
    }

    private void evictLeastRecentlyUsed() {
        Node<K, V> lru = tail.prev; // node just before the tail sentinel
        remove(lru);
        map.remove(lru.key);
    }

    /** Debug view: MRU on the left, LRU on the right. */
    public String snapshot() {
        StringBuilder sb = new StringBuilder("[MRU] ");
        for (Node<K, V> cur = head.next; cur != tail; cur = cur.next) {
            sb.append(cur.key).append("=").append(cur.value).append("  ");
        }
        return sb.append("[LRU]").toString();
    }
}
