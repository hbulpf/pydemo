package solution;

import java.util.Arrays;

/**
 * 这道题一定要注意numRows为1的情况
 */
public class ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        String[] strs = new String[numRows];
        Arrays.fill(strs, "");

        boolean down = true;
        for (int i = 0, k = 0; k < s.length(); k++) {
            strs[i] += s.substring(k, k + 1);

            if (down) {
                if (i < numRows - 1) {
                    i++;
                } else {
                    i--;
                    down = false;
                }
            } else {
                if (i > 0) {
                    i--;
                } else {
                    i++;
                    down = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
