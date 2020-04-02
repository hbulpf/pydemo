package solution;

public class ReverseBits {


    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 32) {
            sb.insert(0, 0);
        }
        s = sb.reverse().toString();
        long value = Long.valueOf(s, 2);
        return (int) value;
    }

    // 耗时2ms，比上面快得多
    public int reverseBits2(int n) {
        int r = 0;
        for (int i = 0; i < 32; i++, n >>>= 1) {
            r = (r << 1) + (n & 1);
        }
        return r;
    }
}
