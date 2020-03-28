public class WildcardMatching {

    // 这道题关键是遇到"*"的处理以及后面匹配失败时的回溯
    // 只要有"*"，当后面匹配失败时就有重试的机会
    public boolean isMatch2(String s, String p) {
        int is = 0, ip = 0, ks = -1, kp = -1;

        while (is < s.length()) {
            // 如果当前能匹配则往下走
            if (ip < p.length() && (s.charAt(is) == p.charAt(ip) || p.charAt(ip) == '?')) {
                is++;
                ip++;
            } else if (ip < p.length() && p.charAt(ip) == '*') {
                // 如果遇到"*"记下s和p当前位置，便于后面匹配失败时回溯，遇到新的"*"时会覆盖之前的"*"
                // 这里is不递增，仅ip递增
                ks = is;
                kp = ip;
                ip++;
            } else if (kp != -1) {
                // 如果p到头了，或者匹配失败了，回归到之前记下的位置，注意每次回溯时的p的位置都是固定的，但是
                // 回溯时的s的位置每次都要加1，因为上次的位置是失败的，所以这次回溯要跳过上次的位置
                is = ++ks;
                ip = kp + 1;
            } else {
                // p到头了，或者匹配失败了，但是没有可回溯的
                return false;
            }
        }

        // 这里要跳过重复的*，如果p也到头了，则是匹配的
        for ( ; ip < p.length() && p.charAt(ip) == '*'; ip++);
        return ip == p.length();
    }
}
