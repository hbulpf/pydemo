package solution;

/**
 * 要注意，这道题不能用window法来做，window法是先尽可能扩张window到不符合条件，然后
 * 缩小window直到将不符合因素排除，所以通常适用于AtMost类型的问题，因为首先要超出most，
 * 然后不断削减直到满足most。
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    // 要注意k=1的情况
    public int longestSubstring(String s, int k) {
        int len = s.length(), max = 0;

        // 要注意k<=1的情况
        if (k <= 1) {
            return len;
        }

        for (int i = 0; i + k <= len; ) {
            int[] counts = new int[256];

            // 这里初始化为i很关键，如果下面没找到满足条件的，则下次i=i+1
            int index = i;

            for (int j = i, key = 0; j < len; j++) {
                int count = ++counts[s.charAt(j)];

                // 这里要注意k必须大于1才行
                if (count == k) {
                    key--;
                } else if (count == 1) {
                    key++;
                }

                if (key == 0) {
                    index = j;
                    max = Math.max(max, j - i + 1);
                }
            }

            // 这句非常关键，如果用i++则会超时
            // 上次如果一直到index都满足条件，那么以[i,index]区间内的任何数为起点都不会再找到比之前更长的子串
            i = index + 1;
        }

        return max;
    }
}
