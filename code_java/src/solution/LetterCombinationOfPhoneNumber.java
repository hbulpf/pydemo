package solution;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhoneNumber {

    /**
     * leetcode的测试用例中不包括包含"0"或"1"的情况
     */

    private static final String[] ARR = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    // 耗时2ms
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        dfs(digits, new StringBuilder(), res, 0);
        return res;
    }

    private void dfs(String digits, StringBuilder sb, List<String> res, int start) {
        if (start >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        int n = digits.charAt(start) - '0';
        for (char c : ARR[n].toCharArray()) {
            sb.append(c);
            dfs(digits, sb, res, start + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}
