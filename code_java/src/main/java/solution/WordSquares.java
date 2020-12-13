package solution;

import java.util.*;

/**
 * https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16
 * 第一步建立所有前缀对应的字符串集合
 * 第二步依次填充
 */
public class WordSquares {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> ret = new ArrayList<List<String>>();
        if (words.length == 0 || words[0].length() == 0) {
            return ret;
        }
        Map<String, Set<String>> map = new HashMap<>();
        int squareLen = words[0].length();
        for (int i = 0; i < words.length; i++) {
            /**
             * 注意这里空字符也算前缀，所以j从-1开始
             */
            for (int j = -1; j < words[0].length(); j++) {
                String prefix = words[i].substring(0, j + 1);
                Set<String> set = map.get(prefix);
                if (set == null) {
                    set = new HashSet<String>();
                    map.put(prefix, set);
                }
                set.add(words[i]);
            }
        }
        helper(ret, new ArrayList<String>(), squareLen, map);
        return ret;
    }

    public void helper(List<List<String>> ret, List<String> cur, int total, Map<String, Set<String>> map) {
        if (cur.size() == total) {
            ret.add(new ArrayList<String>(cur));
            return;
        }
        // build search string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cur.size(); i++) {
            /**
             * 下一个单词的prefix必然是当前这些单词的第cur.size列
             */
            sb.append(cur.get(i).charAt(cur.size()));
        }
        // bachtracking
        Set<String> cand = map.get(sb.toString());
        if (cand == null) {
            return;
        }
        for (String str : cand) {
            cur.add(str);
            helper(ret, cur, total, map);
            cur.remove(cur.size() - 1);
        }
    }
}
