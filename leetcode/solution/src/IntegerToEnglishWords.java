/**
 * TestCase
 * 0
 * 1001
 * 1000000
 */
public class IntegerToEnglishWords {

    private final String[] LESS_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private final String[] LESS_100 = {
            "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    // 这种写法耗时4ms，简洁效率还高

    /**
     * 1, 别漏了zero的情况
     * 2， 当num % 1000 != 0的判断别掉了
     * 3， helper的返回结果要trim一下，去掉前后多余的空格
     * 4， 最后返回的sb要trim一下
     */
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < THOUSANDS.length && num > 0; i++) {
            if (num % 1000 != 0) {
                sb.insert(0, helper(num % 1000).trim() + " " + THOUSANDS[i] + " ");
            }

            num /= 1000;
        }

        return sb.toString().trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return LESS_20[num];
        } else if (num < 100) {
            return LESS_100[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
