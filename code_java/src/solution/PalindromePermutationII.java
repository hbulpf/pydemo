package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/articles/palindrome-permutation-ii/
 */
public class PalindromePermutationII {
    /**
     * 这题就是生成一半的所有排列，然后镜像
     */
    public static List<String> generatePalindromes(String s) {
        int[] counts = new int[256];
        for (char c : s.toCharArray()) {
            counts[c]++;
        }
        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        char single = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] % 2 != 0) {
                if (single != 0) {
                    return list;
                }
                single = (char) i;
                counts[i] = ((counts[i] >> 1) << 1);
            }
            for (int j = 0; j < counts[i]; j += 2) {
                sb.append((char)i);
            }
        }

        helper(sb, "" + (single != 0 ? single : ""), list);
        return list;
    }

    private static void helper(StringBuilder sb, String cur, List<String> list) {
        if (sb.length() == 0) {
            list.add(cur);
            return;
        }

        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1)) {
                continue;
            }
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            helper(sb, c + cur + c, list);
            sb.insert(i, c);
        }
    }
}
