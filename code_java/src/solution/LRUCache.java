import java.util.HashMap;

public class LRUCache {

    private Node mHead;
    private HashMap<Integer, Node> mMap;
    private int mCapacity;

    public LRUCache(int capacity) {
        mMap = new HashMap<>();
        mCapacity = capacity;
        mHead = new Node(0, 0);
    }

    public int get(int key) {
        if (!mMap.containsKey(key)) {
            return -1;
        }
        Node node = mMap.get(key);
        node.remove();
        node.add(mHead);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = mMap.get(key);
        if (node == null) {
            node = new Node(key, value);
            mMap.put(key, node);
        } else {
            node.val = value;
            node.remove();
        }
        node.add(mHead);
        if (mMap.size() > mCapacity) {
            Node prev = mHead.prev;
            prev.remove();
            mMap.remove(prev.key);
        }
    }

    class Node {
        Node prev, next;
        int key, val;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = this;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }

        void add(Node head) {
            next = head.next;
            head.next.prev = this;
            prev = head;
            head.next = this;
        }
    }
}
