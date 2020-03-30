public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] result = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int n = result[i + j + 1] + n1 * n2;
                result[i + j + 1] = n % 10;
                result[i + j] += n / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0 || sb.length() > 0) {
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
