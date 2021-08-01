package solution;

import java.util.*;

/**
 * 这题的区别在于允许数字重复，那么保存index需要用set，删除的时候从set中随便删一个就行了
 */
public class InsertDeleteGetRandomII {

    private HashMap<Integer, HashSet<Integer>> map;
    private List<Integer> list = new ArrayList<Integer>();
    private Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomII() {
        map = new HashMap<Integer, HashSet<Integer>>();
        list = new Vector<Integer>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);

        if (!contains) {
            map.put(val, new HashSet<Integer>());
        }

        list.add(val);
        HashSet<Integer> index = map.get(val);
        index.add(list.size() - 1);

        return !contains;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        HashSet<Integer> indexes = map.get(val);

        if (indexes.isEmpty()) {
            return false;
        }

        int index = indexes.iterator().next();

        /**
         * 这里有个地方非常容易错，那就是indexes.remove(index)不能放到下面的if块之后
         * 为什么呢？假设要remove的数有多个，其中一个恰好在链表末尾，而此处
         * 选中的index在链表中间，如果下面这句放到if后的话，会将末尾和中间的都删了
         */
        indexes.remove(index);

        if (index < list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);

            map.get(last).remove(list.size() - 1);
            map.get(last).add(index);
        }

        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
