import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * 和LRU的区别是
 * LRU，即便历史频率再高，如果最近用的少了一样踢掉
 * LFU，即便最近用的少了，如果曾经频率高一样不会踢
 */
/**
 * http://bookshadow.com/weblog/2016/11/22/leetcode-lfu-cache/
 */
public class LFUCache {

    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Node> nodeMap;
    Node head;
    int capacity;

    public LFUCache(int capacity) {
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
        head = new Node();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        }
        updateFreq(key);
        return valueMap.get(key);
    }

    // 注意capacity为0的情况
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        // 注意只有要新增节点时才先删旧的
        if (!valueMap.containsKey(key)) {
            removeOld();
        }
        valueMap.put(key, value);
        Node node = nodeMap.get(key);
        if (node == null) {
            head.set.add(key);
            nodeMap.put(key, head);
        }
        updateFreq(key);
    }

    /**
     * 访问某个key后更新频率
     * 特殊的新增的某个key先丢到head中再更新
     */
    void updateFreq(int key) {
        Node node = nodeMap.get(key);
        node.set.remove(key);
        Node next = node.next;
        if (next.freq != node.freq + 1) {
            next = new Node(node.freq + 1);
            node.add(next);
        }
        if (node.set.isEmpty() && node != head) {
            node.remove();
        }
        nodeMap.put(key, next);
        next.set.add(key);
    }

    /**
     * 删除频率最小的
     */
    private void removeOld() {
        if (valueMap.size() >= capacity) {
            Node node = head.next;
            int key = node.set.iterator().next();
            node.set.remove(key);
            valueMap.remove(key);
            nodeMap.remove(key);
            if (node.set.isEmpty()) {
                node.remove();
            }
        }
    }

    class Node {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int freq;
        Node prev, next;

        Node() {
            prev = next = this;
        }

        Node(int freq) {
            this.freq = freq;
        }

        void add(Node node) {
            node.next = next;
            next.prev = node;
            this.next = node;
            node.prev = this;
        }

        void remove() {
            prev.next = next;
            next.prev = prev;
        }
    }
}
