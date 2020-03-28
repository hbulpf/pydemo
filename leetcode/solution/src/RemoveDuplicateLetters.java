public class RemoveDuplicateLetters {


    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }

        int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }

        int pos = 0;
        /**
         * 不断尽可能往后走，直到要略过唯一剩下的那个字符时停下
         */
        for (int i = 0; i < s.length(); i++) {
            /**
             * 这里记录下最小的那个字符最开始出现的位置，为什么不记录该字符别的位置呢，比如"abacb"，如果这里取最后一个a的位置，最后结果会是acb，但应该是abc。
             */
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            /**
             * 这里因为要略过当前字符了，所以剩余的字符串里这个字符数要减1，如果为0说明这个字符
             * 只剩唯一一个了，不能再往后走了
             */
            if (--f[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        String right = s.substring(pos + 1).replaceAll(s.substring(pos, pos + 1), "");
        return s.charAt(pos) + removeDuplicateLetters(right);
    }
}
