package solution;

import java.util.*;

public class GroupShiftedStrings {
    /**
     * 这里核心是getTag，不论怎么shift，都回滚到a开头
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String key = getTag(s);
            List<String> value = map.get(key);
            if (value == null) {
                value = new ArrayList<>();
                map.put(key, value);
            }

            value.add(s);
        }

        List<List<String>> ret = new ArrayList<>();
        for (List<String> lst : map.values()) {
            Collections.sort(lst); // dont forget to sort.
            ret.add(lst);
        }

        return ret;
    }

    String getTag(String s) {
        int diff = (int) s.charAt(0) - (int) 'a';

        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((c + 26 - diff) % 26);

        return sb.toString();
    }
}
