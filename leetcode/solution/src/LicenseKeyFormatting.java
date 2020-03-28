/**
 * 将字符串s按长度k为一组，从右往左重排，组之间用"-"分隔，还要转成大写
 * 注意别在最前面多加一个"-"，即下面判断i != 0
 */
public class LicenseKeyFormatting {

    // 耗时13ms
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        for (int i = S.length() - 1, j = 0; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (j % K == 0 && sb.length() > 0) {
                    sb.append("-");
                }

                sb.append(Character.toUpperCase(S.charAt(i)));
                j++;
            }
        }

        return sb.reverse().toString();
    }
}
