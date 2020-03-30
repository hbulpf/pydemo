package solution;

/**
 * https://leetcode.com/articles/first-bad-version/
 */
public abstract class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + ((right - left) >>> 1);

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int firstBadVersion2(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);

            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    abstract boolean isBadVersion(int version);
}
