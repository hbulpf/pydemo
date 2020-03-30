import java.util.*;

/**
 * 这题是个典型的DFS，不过为了加速用了缓存避免重复计算
 * https://leetcode.com/articles/word-break-ii/
 */
public class WordBreakII {

    /**
     * 下面这种写法可以AC，不过当wordDict很大时则效率堪忧
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> dfs(String s, Set<String> wordDict, Map<String, List<String>> map) {
        if (s.length() == 0) {
            return Arrays.asList("");
        }

        List<String> result = map.get(s);

        if (result != null) {
            return result;
        } else {
            result = new LinkedList<String>();
            map.put(s, result);
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = dfs(s.substring(word.length()), wordDict, map);
                for (String text : list) {
                    result.add(word + (text.length() > 0 ? " " + text : ""));
                }
            }
        }
        return result;
    }

    /**
     * 这种写法耗时16ms，效率不错
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashMap<String, List<String>> cache = new HashMap<>();
        cache.put("", Arrays.asList(""));
        return dfs(s, new HashSet<String>(wordDict), cache);
    }

    private List<String> dfs(String s, HashSet<String> wordDict, HashMap<String, List<String>> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> list = dfs(s.substring(0, i), wordDict, cache);
                if (list != null) {
                    for (String ss : list) {
                        result.add((ss.length() > 0 ? ss + " " : "") + t);
                    }
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
