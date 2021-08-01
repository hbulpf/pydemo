package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {

    // 12ms
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] cc = s.toCharArray();
            Arrays.sort(cc);

            String t = new String(cc);

            List<String> list = map.get(t);
            if (list == null) {
                list = new LinkedList<>();
                map.put(t, list);
            }

            list.add(s);
        }

        return new LinkedList<>(map.values());
    }

}
