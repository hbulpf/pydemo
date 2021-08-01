package solution;

public class StrStr {

    // 这里非常重要的是i<=len1-len2，如果没有这个会超时
    // 比如needle非常长的时候
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        for (int i = 0, j; i + l2 - 1 < l1; i++) {
            for (j = 0; j < l2; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j >= l2) {
                return i;
            }
        }
        return -1;
    }
}
