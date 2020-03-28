public class CommonUtils {


    public static char[][] getChars(String[] strs) {
        char[][] board = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            board[i] = strs[i].toCharArray();
        }
        return board;
    }
}
