package solution;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int k = 0;
        for (int i = x ^ y; i != 0; i &= i - 1, k++);
        return k;
    }
}
