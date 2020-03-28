public class MinimumWindowSubstring {

    // 耗时6ms，时间复杂度O(n)
    public String minWindow(String s, String t) {
        int[] tc = new int[256], sc = new int[256];
        for (char c : t.toCharArray()) {
            tc[c]++;
        }
        int count = 0, min = Integer.MAX_VALUE, start = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (++sc[c] <= tc[c]) {
                ++count;
            }
            if (count == t.length()) {
                for ( ; i < j; i++) {
                    char cc = s.charAt(i);
                    if (sc[cc] <= tc[cc]) {
                        break;
                    }
                    sc[cc]--;
                }
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    start = i;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
