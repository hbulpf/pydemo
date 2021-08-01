package solution;

/**
 * https://leetcode.com/articles/reverse-words-in-a-string/
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] texts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String text : texts) {
            if (text.length() > 0) {
                sb.append(new StringBuilder(text).reverse().toString()).append(" ");
            }
        }
        return sb.toString().trim();
    }
}
