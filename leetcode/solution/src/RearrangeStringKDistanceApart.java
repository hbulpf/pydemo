import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart {
    /**
     * 这题思路是先统计有哪些字符，并将这些字符按频率从高到底放在优先队列中，由于相同字符之间距离至少是k，
     * 所以我们以k个字符为1组来拼字符串。我们每次优先取队列中最高频的字符，取完一轮后剩下的字符再加到队列中取第二轮，
     * 一直到队列中没有足够的字符供我们取时截止。
     */
    /**
     * 时间复杂度O(nlgm)，n为字符串长度，m为字符串中不同的字符数，注意这里与k无关。
     */
    public String rearrangeString(String str, int k) {
        if (k == 0) {
            return str;
        }
        int[] f = new int[26];
        for (char c : str.toCharArray()) {
            f[c - 'a']++;
        }
        Queue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return f[o1 - 'a'] != f[o2 - 'a'] ? f[o2 - 'a'] - f[o1 - 'a'] : o1.compareTo(o2);
            }
        });
        for (int i = 0; i < f.length; i++) {
            if (f[i] > 0) {
                queue.add((char) (i + 'a'));
            }
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        Queue<Character> next = new LinkedList<>();
        while (!queue.isEmpty()) {
            int n = Math.min(len, k);
            for (int i = 0; i < n; i++) {
                if (queue.isEmpty()) {
                    return "";
                }
                char c = queue.poll();
                sb.append(c);
                if (--f[c - 'a'] > 0) {
                    next.add(c);
                }
                len--;
            }
            queue.addAll(next);
            next.clear();
        }
        return sb.toString();
    }
}
