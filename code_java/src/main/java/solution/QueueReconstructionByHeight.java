package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 这题核心思路是：
 * 1，先取出高度最高的那一组，如果有若干个高度相同的，则按k升序排列，这就是他们之后的相对顺序了。
 * 2，排除刚取出的那些组，从剩余的组中再取出最高的，仍按k升序排列，然后依次插入
 * <p>
 * 这题核心思路是：
 * 1，先取出高度最高的那一组，如果有若干个高度相同的，则按k升序排列，这就是他们之后的相对顺序了。
 * 2，排除刚取出的那些组，从剩余的组中再取出最高的，仍按k升序排列，然后依次插入
 */

/**
 * 这题核心思路是：
 * 1，先取出高度最高的那一组，如果有若干个高度相同的，则按k升序排列，这就是他们之后的相对顺序了。
 * 2，排除刚取出的那些组，从剩余的组中再取出最高的，仍按k升序排列，然后依次插入
 */

/**
 * 为什么要这么做呢？先处理较高的，相对顺序就固定了，再往里插较低的时也不会影响较高的组的k值。
 * 而高度相同的组，往前排的k肯定会更小，所以我们按k的升序排好就是他们最后的相对顺序了。
 */
public class QueueReconstructionByHeight {

    // [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
    // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
