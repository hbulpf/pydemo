import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPalindromePair(words[i], words[j])) {
                    result.add(Arrays.asList(i, j));
                }
                if (isPalindromePair(words[j], words[i])) {
                    result.add(Arrays.asList(j, i));
                }
            }
        }
        return result;
    }

    private boolean isPalindromePair(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        for (int l = 0, r = len1 + len2 - 1; l < r; l++, r--) {
            char c1 = l < len1 ? word1.charAt(l) : word2.charAt(l - len1);
            char c2 = r < len1 ? word1.charAt(r) : word2.charAt(r - len1);
            if (c1 != c2) {
                return false;
            }
        }

        return true;
    }

    /**
    public List<List<Integer>> palindromePairs2(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        if (words == null || words.length < 2) {
            return result;
        }

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);

                if (isPalindrome(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        result.add(Arrays.asList(map.get(str2rvs), i));
                    }
                }

                if (str2.length() != 0 && isPalindrome(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i) {
                        result.add(Arrays.asList(i, map.get(str1rvs)));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) !=  str.charAt(right--)) return false;
        }
        return true;
    }
     */
}
