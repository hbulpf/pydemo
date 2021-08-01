package solution;

import java.util.*;

/**
 * <p>
 * TestCases
 * "z", "z" => "z"
 * "za", "zb", "ca", "cb" => "zacb"
 */

/**
 * TestCases
 * "z", "z" => "z"
 * "za", "zb", "ca", "cb" => "zacb"
 */

/**
 * 这题有几个地方容易错，
 * 1. 开头要初始化所有出现过的字符的degree为0，且要记下这些字符数count，结尾的时候要对比生成的字典长度是否和count相等，如果不等说明有环，返回空
 * 3. 在对比两个单词时，当first从开头包含second时，是不符合顺序的，如"abc"和"ab"，直接返回空
 * 4. 在设置degreee时要避免重复添加，比如'a'->'b'出现了多次，degree只能加1次
 * 5. degree设置的时候要注意字符和索引换算
 */
public class AlienDictionary {

    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);

        /**
         * 初始化indegree并统计字符数
         */
        int count = 0;
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (indegree[c - 'a'] != 0) {
                    indegree[c - 'a'] = 0;
                    count++;
                }
            }
        }

        /**
         * 计算所有字符的indegree，注意这里是相邻两个单词比对
         */
        HashMap<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i], second = words[i + 1];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    Set<Character> set = map.get(first.charAt(j));
                    if (set == null) {
                        set = new HashSet<Character>();
                        map.put(first.charAt(j), set);
                    }
                    /**
                     * 注意同一条边不能重复加入了
                     */
                    if (set.add(second.charAt(j))) {
                        indegree[second.charAt(j) - 'a']++;
                    }
                    /**
                     * 注意这里要break
                     */
                    break;
                } else {
                    /**
                     * 这种情况说明字典是错误的，直接返回空
                     */
                    if (j + 1 >= second.length() && j + 1 < first.length()) {
                        return "";
                    }
                }
            }
        }

        /**
         * 开始拓扑排序了，先将indegree为0的字符加到queue中
         */
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add((char) ('a' + i));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character from = queue.poll();
            sb.append(from);
            Set<Character> set = map.get(from);
            if (set != null) {
                for (Character to : map.get(from)) {
                    if (--indegree[to - 'a'] == 0) {
                        queue.add(to);
                    }
                }
            }
        }
        return sb.length() != count ? "" : sb.toString();
    }
}
