package solution;

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        int character[] = new int[256];
        for (char c : J.toCharArray()) {
            character[c]++;
        }
        int count = 0;
        for (char c : S.toCharArray()) {
            if (character[c] > 0) {
                count++;
            }
        }
        return count;
    }
}
