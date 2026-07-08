package model;

/**
 * A node in the doubly linked list the cache uses to track recency.
 * Doubly linked (prev AND next) so any node can be unlinked in O(1) — that's
 * the whole reason we don't use a singly linked list or an array here.
 * Fields are public because this is an internal helper for LRUCache.
 */
public class Node<K, V> {
    public K key;
    public V value;
    public Node<K, V> prev;
    public Node<K, V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
