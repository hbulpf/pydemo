public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1, flag = 0; i >= 0 || j >= 0 || flag > 0; i--, j--) {
            int k1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int k2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = k1 + k2 + flag;
            sb.append(sum % 2);
            flag = sum / 2;
        }
        return sb.reverse().toString();
    }
}
