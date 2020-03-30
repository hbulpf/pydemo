/**
 * 旋转180度，而不是上下镜像
 */
public class StrobogrammaticNumber {

    public boolean isStrobogrammatic(String num) {
        for (int i = 0, j = num.length() - 1; i <= j; i++, j--) {
            if (!"11 88 00 696".contains(num.charAt(i) + "" + num.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
