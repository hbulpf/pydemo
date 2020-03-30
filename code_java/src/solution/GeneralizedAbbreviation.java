import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/articles/generalized-abbreviation/
 * 思路就是back tracking，对于每个字母，到底是选择留下还是缩写
 */
public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {
        List<String> list = new LinkedList<>();
        helper(word, 0, list, "", 0);
        return list;
    }

    private void helper(String word, int idx, List<String> list, String cur, int count) {
        if (idx == word.length()) {
            if (count > 0) {
                cur += count;
            }
            list.add(cur);
            return;
        }

        helper(word, idx + 1, list, cur, count + 1);
        helper(word, idx + 1, list, cur + (count > 0 ? count : "") + word.charAt(idx), 0);
    }
}
