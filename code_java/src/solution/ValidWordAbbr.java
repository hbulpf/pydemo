import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 参考https://leetcode.com/articles/unique-word-abbreviation/
 */
public class ValidWordAbbr {
    /**
     * 这题容易错的地方是unique的理解，即dic中不存在该word，要排除word
     */
    private HashMap<String, Set<String>> mMap;

    public ValidWordAbbr(String[] dictionary) {
        mMap = new HashMap<String, Set<String>>();
        for (String text : dictionary) {
            String abbr = getAbbr(text);

            Set<String> set = mMap.get(abbr);
            if (set == null) {
                set = new HashSet<String>();
                mMap.put(abbr, set);
            }
            set.add(text);
        }
    }

    /**
     * unique意味着不存在该abbr或存在但是只有该单词一个
     */
    public boolean isUnique(String word) {
        Set<String> set = mMap.get(getAbbr(word));
        return set == null || (set.size() == 1 && set.contains(word));
    }

    private String getAbbr(String s) {
        return s.length() > 2 ? s.substring(0, 1) + (s.length() - 2) + s.substring(s.length() - 1) : s;
    }
}
