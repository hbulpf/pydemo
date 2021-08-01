package solution;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        int i = 0;
        for ( ; i < sb.length() && sb.charAt(i) == '0'; i++);
        return i >= sb.length() ? "0" : sb.substring(i);
    }
}
