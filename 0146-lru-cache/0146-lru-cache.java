import java.util.*;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity;

    Node left;   // dummy LRU
    Node right;  // dummy MRU

    public LRUCache(int capacity) {
        this.capacity = capacity;

        left = new Node(0, 0);
        right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    // Remove node from DLL
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert node before right (MRU)
    private void insert(Node node) {
        Node prev = right.prev;

        prev.next = node;
        node.prev = prev;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {

        if (!map.containsKey(key))
            return -1;

        Node node = map.get(key);

        // It was just used → make it MRU
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node old = map.get(key);
            remove(old);
            map.remove(key);
        }

        Node node = new Node(key, value);

        map.put(key, node);
        insert(node);

        if (map.size() > capacity) {

            // First real node = LRU
            Node lru = left.next;

            remove(lru);
            map.remove(lru.key);
        }
    }
}