package solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TestCase
 * ""
 * "x("
 * "("
 */
public class RemoveInvalidParentheses {

    /**
     * BFS法，遍历s，依次去掉一个'('或')'，然后加入队列，判断是否是合法序列
     * 遇到合法序列，则将该层所有序列都找出来
     * 最差时间复杂度O(n*2^n)
     */
    // 耗时97ms
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<String>();
        Queue<String> next = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        List<String> result = new LinkedList<String>();

        queue.add(s);
        while (!queue.isEmpty()) {
            String ss = queue.poll();
            if (isValidParentheses(ss)) {
                result.add(ss);
            } else {
                for (int i = 0; i < ss.length(); i++) {
                    /**
                     * 注意这里如果是非括号要跳过
                     */
                    if (ss.charAt(i) != '(' && ss.charAt(i) != ')') {
                        continue;
                    }
                    String st = ss.substring(0, i) + ss.substring(i + 1);
                    if (visited.add(st)) {
                        next.add(st);
                    }
                }
            }

            if (queue.isEmpty() && result.isEmpty()) {
                queue.addAll(next);
                next.clear();
            }
        }

        return result;
    }

    private boolean isValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                // 这里要注意如果中途count<0了就非法了
                if (--count < 0) {
                    return false;
                }
            }
        }
        // 最后的返回条件要注意
        return count == 0;
    }

    /**
     * 字符串不是合法的序列有两种情况，一种是'('和')'个数不对称，另一种是个数一样，但是顺序有问题，比如")("
     * 所以判断字符串是否合法的指标有三个，即'('和')'个数一样，且count=0，但是在对比'('和')'个数时要注意，要用增量，而不是全量
     * 如果用全量，最后返回的结果会包括不是最长的合法串，比如对于"()())()",返回的是"()()","()","(())","()()()","(())()"
     * 如果用增量就不会有这个问题，只要给有问题的部分减到0即可，而不是全量部分减到0
     */
    // 耗时9ms，时间复杂度仍然是O(n*2^n)，只不过这里剪枝很多
    public List<String> removeInvalidParentheses2(String s) {
        int nL = 0, nR = 0;
        // 这样统计出来的增量表示的是不平衡度，特别的有')('，nl和nr都为1
        // 我们要给不平衡度都减到0，就是合法串了
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                nL++;
            } else if (s.charAt(i) == ')') {
                if (nL > 0) {
                    nL--;
                } else {
                    nR++;
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        dfs(s, 0, set, "", nL, nR, 0);
        return new LinkedList<String>(set);
    }

    private void dfs(String s, int i, HashSet<String> set, String t, int nL, int nR, int count) {
        if (nL < 0 || nR < 0 || count < 0) {
            return;
        }

        if (i == s.length()) {
            if (nL == 0 && nR == 0 && count == 0) {
                set.add(t);
            }
            return;
        }

        char c = s.charAt(i);
        if (c == '(') {
            dfs(s, i + 1, set, t, nL - 1, nR, count);
            dfs(s, i + 1, set, t + "(", nL, nR, count + 1);
        } else if (s.charAt(i) == ')') {
            dfs(s, i + 1, set, t, nL, nR - 1, count);
            dfs(s, i + 1, set, t + ")", nL, nR, count - 1);
        } else {
            dfs(s, i + 1, set, t + c, nL, nR, count);
        }
    }
}
