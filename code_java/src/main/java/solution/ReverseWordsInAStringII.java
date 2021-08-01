package solution;

public class ReverseWordsInAStringII {

    public void reverseWords(char[] s) {
        for (int i = 0, j = i; i < s.length; ) {
            if (j >= s.length || s[j] == ' ') {
                reverse(s, i, j - 1);
                for (i = j; j < s.length && s[j] == ' '; j++, i = j) ;
            } else {
                j++;
            }
        }
        reverse(s, 0, s.length - 1);
    }

    private void reverse(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
        }
    }
}
