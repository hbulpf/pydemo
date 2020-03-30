public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        int i, j = 0;
        boolean flag = false;

        StringBuilder sb = new StringBuilder();

        for (i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (!flag) {
                    continue;
                } else {
                    flag = false;
                    sb.append(s.substring(i + 1, j + 1)).append(" ");
                }
            } else {
                if (!flag) {
                    flag = true;
                    j = i;
                }
            }
        }

        if (flag) {
            sb.append(s.substring(i + 1, j + 1));
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
