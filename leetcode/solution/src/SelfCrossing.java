/**
 * 这题非常数学，最好画一下，总的来说可以归纳为三种情况：
 * 1. 第4条线和第1条线相交
 * 2. 第5条线和第1条线相交
 * 3. 第6条线和第1条线相交
 */
public class SelfCrossing {

    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;  //Fourth line crosses first line and onward
            }
            if (i >= 4) {
                if (x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                    return true; // Fifth line meets first line and onward
                }
            }
            if (i >= 5) {
                if (x[i - 2] - x[i - 4] >= 0 && x[i] >= x[i - 2] - x[i - 4]
                        && x[i - 1] >= x[i - 3] - x[i - 5] && x[i - 1] <= x[i - 3]) {
                    return true;  // Sixth line crosses first line and onward
                }
            }
        }
        return false;
    }
}
