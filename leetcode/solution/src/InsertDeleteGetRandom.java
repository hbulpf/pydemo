import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 有几点要注意：
 * remove时要判断删除的是不是最后一个，另外交换了结尾后要更新结尾数的idx
 */
// 耗时111ms
public class InsertDeleteGetRandom {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int index = map.getOrDefault(val, -1);
        if (index < 0) {
            return false;
        }
        if (index != list.size() - 1) {
            int tail = list.get(list.size() - 1);
            list.set(index, tail);
            map.put(tail, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        index = (index >= 0 ? index : -index);
        return list.get(index);
    }
}
