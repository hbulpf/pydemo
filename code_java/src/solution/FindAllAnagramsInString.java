import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagramsInString {

    // 耗时16ms，复杂度O(n)

    /**
     * 1, 当发现某个字符不在s中时，start不断增加，直到end
     * 2, 当发现某个字符数超过s时，start不断增加，直到该字符数不再超过
     * 3, 当发现长度和p一致时，就是找到结果了，start++
     * 4, 中间态，end++
     */
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[256], temp = new int[256];

        for (char c : p.toCharArray()) {
            count[c]++;
        }

        List<Integer> result = new LinkedList<>();

        int sl = s.length(), pl = p.length();

        for (int start = 0, end = 0; end < sl; ) {
            char c = s.charAt(end);

            if (count[c] == 0) {
                if (start <= end) {
                    temp[s.charAt(start++)]--;
                } else {
                    end++;
                }
                continue;
            }

            if (temp[c] >= count[c]) {
                temp[s.charAt(start++)]--;
                continue;
            }

            temp[c]++;

            if (end - start + 1 == pl) {
                result.add(start);
                temp[s.charAt(start++)]--;
            }

            end++;
        }

        return result;
    }

    // disscus上的做法
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[256]; //character hash

        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right)] >= 1) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                list.add(left);
            }
            if (right - left == p.length()) {

                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;

            }


        }
        return list;
    }
}
