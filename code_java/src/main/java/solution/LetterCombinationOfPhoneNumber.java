package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 解法：
 * 1. 递归/回溯：最后一次递归才加入结果列表
 * O(T) = 3^N*4*M
 * O(S) = 3^N*4*M
 * @Author: RunAtWorld
 * @Date: 2020/6/18 0:23
 */
public class LetterCombinationOfPhoneNumber {
    // ----------------------解法1----------------------
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

   // ----------------------解法2----------------------
    Map<String, String> phoneMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    List<String> resList = new ArrayList<>();

    public void backTrack(String combination, String digits) {
        if (digits.length() == 0) {
            //最后一次递归才加入结果列表
            resList.add(combination);
        }else {
            String digit = digits.substring(0, 1);
            String nextDigits = digits.substring(1);
            String letters = phoneMap.get(digit);
            for (char ch : letters.toCharArray()) {
                backTrack(combination + ch, nextDigits);
            }
        }
    }

    /**
     * O(T) = 3^N*4*M
     * O(S) = 3^N*4*M
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        if (digits != null && digits.length() != 0) {
            backTrack("", digits);
        }
        return resList;
    }
}
