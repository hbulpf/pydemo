import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {

    // 118ms，最直接的做法

    // 这些words可能有重复
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();

        if (words.length == 0 || s.length() == 0) {
            return list;
        }

        int len = words[0].length();
        int total = len * words.length;

        if (s.length() < total) {
            return list;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 1 + map.getOrDefault(word, 0));
        }

        for (int i = 0; i <= s.length() - total; ) {
            if (isMatch(s, i, i + total, len, map)) {
                list.add(i);
            }

            i++;
        }

        return list;
    }

    private boolean isMatch(String s, int start, int end, int len, HashMap<String, Integer> map0) {
        HashMap<String, Integer> map = new HashMap<>(map0);

        for (int i = start; i < end; i += len) {
            String t = s.substring(i, i + len);

            int m = map.getOrDefault(t, 0);

            if (m > 1) {
                map.put(t, m - 1);
            } else if (m == 1) {
                map.remove(t);
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }
}
