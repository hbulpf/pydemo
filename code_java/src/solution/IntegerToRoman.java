package solution;

public class IntegerToRoman {

    public String intToRoman(int num) {
        String[] K1000 = { "", "M", "MM", "MMM" };
        String[] K100 = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] K10 = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] K1 = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        StringBuilder sb = new StringBuilder();
        sb.append(K1000[num / 1000]);
        sb.append(K100[(num / 100) % 10]);
        sb.append(K10[(num / 10) % 10]);
        sb.append(K1[num % 10]);
        return sb.toString();
    }
}
