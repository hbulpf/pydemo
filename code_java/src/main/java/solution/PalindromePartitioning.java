package solution;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PalindromePartitioning {

    /**
     * 容易错的地方
     * f[0]的初始化
     * f是开区间,flag是闭区间
     * j > i-2
     * i是开区间
     */
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[] f = new LinkedList[n + 1];
        f[0] = new LinkedList<List<String>>();
        f[0].add(Collections.EMPTY_LIST);

        boolean[][] flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            f[i + 1] = new LinkedList<List<String>>();
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i) && (j > i - 2 || flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                    for (List<String> list : f[j]) {
                        List<String> list2 = new LinkedList<String>(list);
                        list2.add(s.substring(j, i + 1));
                        f[i + 1].add(list2);
                    }
                }
            }
        }

        return f[n];
    }
}
