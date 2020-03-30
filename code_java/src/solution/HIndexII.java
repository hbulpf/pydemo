
public class HIndexII {

    // 1 100
    public int hIndex(int[] citations) {
        int len = citations.length, left = 0, right = len - 1;

        while (left <= right) {
            int mid = left + ((right - left) >>> 1);

            int articles = len - mid;

            if (articles == citations[mid]) {
                // 这是临界点，再往下文章数会大于引用
                return articles;
            } else if (articles > citations[mid]) {
                // 文章数大于引用，继续往下走
                left = mid + 1;
            } else {
                // 文章数小于引用，继续往前走
                right = mid - 1;
            }
        }

        return len - left;
    }
}
