import java.util.Arrays;
import java.util.TreeSet;

public class NextClosestTime {

    /**
     * 整体思路如下：
     * 首先对输入的时间所包含的数要统计一下，并从小到大排序
     * 接下来从时间的高位开始，寻找可替代的更大的数，如果找不到，就看下一位，如果找到了就替换成该数，判断时间是否有效
     * 如果有效，则将该位往上全部替换为全局最小的数，并返回结果。否则还原该位，并继续看下一位。
     */
    public String nextClosestTime(String time) {
        int[] number = new int[4];

        time = time.substring(0, 2) + time.substring(3);

        for (int i = 0; i < time.length(); i++) {
            number[i] = time.charAt(i) - '0';
        }

        Arrays.sort(number);

        StringBuilder sb = new StringBuilder(time);

        int i;
        for (i = 3; i >= 0; i--) {
            char c = time.charAt(i);
            int k = nextNumber(number, c - '0');
            if (k >= 0) {
                sb.setCharAt(i, (char) (k + '0'));
                if (isValid(sb)) {
                    break;
                }
                sb.setCharAt(i, c);
            }
        }
        for (i++; i < 4; i++) {
            sb.setCharAt(i, (char) (number[0] + '0'));
        }
        sb.insert(2, ':');
        return sb.toString();
    }

    // 判断时间是否有效
    private boolean isValid(StringBuilder sb) {
        boolean flag1 = sb.charAt(0) < '2' || (sb.charAt(0) == '2' && sb.charAt(1) <= '3');
        boolean flag2 = sb.charAt(2) < '5' || (sb.charAt(2) == '5' && sb.charAt(3) <= '9');
        return flag1 && flag2;
    }

    /**
     * 找比n更大的数，number是一个升序的数组
     */
    private int nextNumber(int[] number, int n) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] > n) {
                return number[i];
            }
        }
        return -1;
    }
}
