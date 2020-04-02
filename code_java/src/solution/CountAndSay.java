package solution;

public class CountAndSay {

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = next(s);
        }
        return s;
    }

    private String next(String s) {
        StringBuilder sb = new StringBuilder();

        char cur = 0;
        int times = 0;

        for (int i = 0; i < s.length(); i++) {
            if (times == 0) {
                cur = s.charAt(i);
                times = 1;
            } else if (s.charAt(i) == cur) {
                times++;
            } else {
                sb.append(String.format("%d%c", times, cur));
                cur = s.charAt(i);
                times = 1;
            }
        }

        // 这一句千万别掉了
        if (times != 0) {
            sb.append(String.format("%d%c", times, cur));
        }

        return sb.toString();
    }
}
