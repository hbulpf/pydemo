import java.util.*;

public class TopKFrequentElements {

    /**
     * 首选方法，时间复杂度O(n)，省去了排序
     * 结尾注意list的size大于k了，要截一部分
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int n : nums) {
            int count = map.getOrDefault(n, 0) + 1;
            map.put(n, count);
            max = Math.max(max, count);
        }
        List<Integer>[] lists = new LinkedList[max + 1];
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (lists[count] == null) {
                lists[count] = new LinkedList<Integer>();
            }
            lists[count].add(key);
        }
        List<Integer> result = new LinkedList<Integer>();
        for (int i = lists.length - 1; i >= 0 && result.size() < k; i--) {
            if (lists[i] != null) {
                result.addAll(lists[i]);
            }
        }
        return result.subList(0, k);
    }

    /**
     * 先统计每个元素次数，再用Priority排序
     */
    // 耗时46ms，最差复杂度O(nlgk)，当k<<n时为O(n)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<Integer>(8, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        for (Integer n : map.keySet()) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for(int num : map.keySet()){
            int freq = map.get(num);
            if(!freqMap.containsKey(freq)){
                freqMap.put(freq, new LinkedList<>());
            }
            freqMap.get(freq).add(num);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, List<Integer>> entry = freqMap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res;
    }
}
