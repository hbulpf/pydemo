package solution;

public class ExcelSheetColumnTitle {

    /**
     * 因为这个字母是从1开始计数的，所以n要先减1
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        for ( ; n > 0; ) {
            n--;
            sb.insert(0, (char) (n % 26 + 'A'));
            n /= 26;
        }
        return sb.toString();
    }
}
