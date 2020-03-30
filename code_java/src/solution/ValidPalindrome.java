public class ValidPalindrome {

    /**
     * 空串认为是true
     */
    // 耗时10ms
    public boolean isPalindrome(String s) {
        /**
         * 因为是忽略大小写，所以这里先转化成小写
         */
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            } else if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            } else {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
