package solution;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddresses {

    /**
     * 注意，0可以，但是00，01， 010这种是不允许的
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, 0, new LinkedList<>(), result);
        return new ArrayList<>(result);
    }

    private void dfs(String s, int index, Deque<String> ips, List<String> result) {
        if (ips.size() > 4) {
            return;
        }
        if (index >= s.length()) {
            if (ips.size() == 4) {
                result.add(String.join(".", ips));
            }
            return;
        }
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String t = s.substring(index, index + i);
            int k = Integer.parseInt(t);
            if (i == 3 && k > 255) {
                break;
            }
            ips.offer(t);
            dfs(s, index + i, ips, result);
            ips.pollLast();

            if (k == 0) {
                break;
            }
        }
    }
}
