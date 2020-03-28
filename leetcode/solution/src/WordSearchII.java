import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    private class Trie {
        Trie[] nodes = new Trie[26];
        String word;
    }

    private void buildTrie(Trie trie, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (trie.nodes[word.charAt(i) - 'a'] == null) {
                trie.nodes[word.charAt(i) - 'a'] = new Trie();
            }
            trie = trie.nodes[word.charAt(i) - 'a'];
        }
        trie.word = word;
    }

    /**
     * 这里相对第一题来说用到了set保存中间结果，而不是直接exist，原因在于假如trie中有ab和abb，则dfs的时候
     * 遇到ab就会返回true了，那么abb永远不会走到，所以我们要dfs到trie结束为止
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            buildTrie(trie, word);
        }
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(set, board, i, j, trie);
            }
        }
        return new LinkedList<String>(set);
    }

    /**
     * 这里容易错的两点
     * 1. if (c < 'a' || c > 'z') 这个容易掉了
     * 2. 要用Set查重，别直接List
     */
    private void dfs(Set<String> set, char[][] board, int i, int j, Trie trie) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (trie == null) {
            return;
        }
        char c = board[i][j];
        /**
         * 这里千万不能掉了
         */
        if (c < 'a' || c > 'z') {
            return;
        }
        trie = trie.nodes[c - 'a'];
        if (trie == null) {
            return;
        }
        if (trie.word != null) {
            set.add(trie.word);
            /**
             * 这里还不能return，比如当前是aa，但是还有aab，所以需要继续dfs
             */
        }

        board[i][j] ^= '#';
        dfs(set, board, i + 1, j, trie);
        dfs(set, board, i - 1, j, trie);
        dfs(set, board, i, j + 1, trie);
        dfs(set, board, i, j - 1, trie);
        board[i][j] ^= '#';
    }
}
