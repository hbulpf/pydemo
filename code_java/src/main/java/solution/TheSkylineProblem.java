package solution;

import java.util.*;

/**
 * 这题的核心就是求外轮廓，就是所有building覆盖到的区域的最高处构成的轮廓，所以我们关注的核心是当前有效区域的最高处，所以我们要维护
 * 一个大端队列，当在当前轮廓上碰到更高的矩形时，会生成一个新转折点，当当前轮廓所在的矩形结束时，轮廓高度会坠落到第二级台阶上。
 *
 * 每个building有两条竖线，左边为升，右边为降。我们遍历所有building，生成所有竖线的集合并排序，注意升线的高度设为负数。
 *
 * 特殊情况：多条竖线重合，有升有降。我们优先看升，且优先看高度最高的升，因为会影响整个外轮廓
 *
 * 当矩形起始时，需要将其高度加入队列，如果其高度高于当前高度，则生成一个转折点，矩形结束时，需要将其高度从队列中去掉，如果结束点不在外轮廓上则不会生成转折点，就是说
 * 即使去掉了该矩形的高度也不会影响队列中的最高高度，那外轮廓就不会变，不会有转折点。
 */
public class TheSkylineProblem {

    // 耗时290ms，复杂度O(nlgn+nlgn+n^2)
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new LinkedList<int[]>();

        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        /**
         * 这里排序先按x，x相同则按高度，由于升线高度为负，所以升线越高越靠前，降线越矮越靠前。
         * x一定时升线高的靠前，因为决定最终结果的是升线最高的那个，如果不是这样，后面处理queue的时候会添加一堆中间结果
         * x一定时降线矮的靠前，因为不这样的话，后面处理queue的时候会添加一堆中间结果
         */
        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        /**
         * 这里别掉了
         */
        queue.offer(0);

        List<int[]> result = new LinkedList<int[]>();

        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                queue.add(-height[1]);
            } else {
                queue.remove(height[1]);
            }
            int cur = queue.peek();
            if (prev != cur) {
                result.add(new int[] {height[0], cur});
                prev = cur;
            }
        }

        return result;
    }

    /**
     * 上面PriorityQueue的remove复杂度为O(n)，所以这里换成了TreeMap，删除的复杂度为O(lgn)
     */
    // 耗时50ms，复杂度O(nlgn+nlgn+nlgn)
    public List<int[]> getSkyline2(int[][] buildings) {
        List<int[]> heights = new LinkedList<int[]>();

        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        Collections.sort(heights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(Collections.<Integer>reverseOrder());

        // 这里一定别掉了
        map.put(0, 1);

        List<int[]> result = new LinkedList<int[]>();

        int prev = 0;
        for (int[] height : heights) {
            if (height[1] < 0) {
                map.put(-height[1], map.getOrDefault(-height[1], 0) + 1);
            } else {
                int cnt = map.getOrDefault(height[1], 0);
                if (cnt == 1) {
                    map.remove(height[1]);
                } else {
                    map.put(height[1], cnt - 1);
                }
            }
            int cur = map.firstKey();
            if (prev != cur) {
                result.add(new int[] {height[0], cur});
                prev = cur;
            }
        }

        return result;
    }
}
