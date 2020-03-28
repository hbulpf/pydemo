public class FlipGameII {

    public boolean canWin(String s) {
        for (int i = 0; i < s.length(); ) {
            int index = s.indexOf("++", i);
            if (index >= i) {
                String t = s.substring(0, index) + "--" + s.substring(index + 2);
                if (!canWin(t)) {
                    return true;
                }
                i = index + 1;
            } else {
                break;
            }
        }
        return false;
    }
}
