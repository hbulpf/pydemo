public class ReverseVowelsOfaString {



    public String reverseVowels(String s) {
        boolean[] flag = new boolean[256];
        for (char c : "aeiouAEIOU".toCharArray()) {
            flag[c] = true;
        }

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0, j = sb.length() - 1; i < j; ) {
            if (!flag[sb.charAt(i)]) {
                i++;
            } else if (!flag[sb.charAt(j)]) {
                j--;
            } else {
                char c = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            }
        }

        return sb.toString();
    }

}
