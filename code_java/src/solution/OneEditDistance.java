public class OneEditDistance {
    /**
     * 最容易错的是结尾的条件sL != tL
     */
    public boolean isOneEditDistance(String s, String t) {
        int sL = s.length(), tL = t.length();
        if (sL > tL) {
            return isOneEditDistance(t, s);
        }
        if (tL - sL > 1) {
            return false;
        }

        for (int i = 0; i < sL; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sL < tL) {
                    return s.substring(i).equals(t.substring(i + 1));
                } else {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }
        return sL != tL;
    }
}
