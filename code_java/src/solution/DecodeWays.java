package solution;

/**
 * TestCases
 * ""
 * "1"
 * "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"
 * "7893749912342187894921836847319981199844151766195952528631828655978178193192959793156142441128167383"
 */
public class DecodeWays {

    // DP，耗时1ms
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = i > 0 ? dp[i - 1] : 1;
            }
            if (i > 0 && (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[len - 1];
    }
}
