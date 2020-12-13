package solution;

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord : d) {
            int i = 0;

            /**
             * 首先要走一遍s的所有字符，如果对上了word则i++
             * 看能不能将word从头对到尾
             */
            for (char c : s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            }

            if (i == dictWord.length() && dictWord.length() >= longest.length()) {
                /**
                 * 相同长度时按字符排序
                 */
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) {
                    longest = dictWord;
                }
            }
        }
        return longest;
    }
}
