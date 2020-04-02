package solution;

/**
 * 先用排除法扫一轮，剩下的是唯一的候选人，然后再严格判断
 */
public abstract class FindCelebrity {

    public int findCelebrity(int n) {
        int candidate = 0;

        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (candidate == i) {
                continue;
            }
            if (knows(candidate, i) || !knows(i, candidate)) {
                return -1;
            }
        }

        return candidate;
    }

    abstract boolean knows(int a, int b);
}
