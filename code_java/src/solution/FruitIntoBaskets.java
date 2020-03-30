import java.util.HashMap;

/**
 * 这题和sliding window较类似
 * 意思是给定一个数组，找出其中的一个最长的连续子数组，只能有两个不同的数
 */
public class FruitIntoBaskets {


    public static int totalFruit(int[] tree) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < tree.length; j++) {
            int value = tree[j];

            map.put(value, map.getOrDefault(value, 0) + 1);

            for ( ; map.size() > 2; i++) {
                int val = tree[i], cnt = map.get(val);
                if (cnt == 1) {
                    map.remove(val);
                } else {
                    map.put(val, cnt - 1);
                }
            }
            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}
