package solution;

public class WordDictionary {

    private class Trie {
        Trie[] nodes = new Trie[26];
        String word;
    }

    Trie root = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Trie node = root;
        for (char c : word.toCharArray()) {
            if (node.nodes[c - 'a'] == null) {
                node.nodes[c - 'a'] = new Trie();
            }
            node = node.nodes[c - 'a'];
        }
        node.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Trie trie, String word, int index) {
        if (trie == null) {
            return false;
        }
        if (index == word.length()) {
            /**
             * 这个返回的条件一定要注意，不是trie.word.equals(word)，因为word中可能带'.'
             */
            return trie.word != null;
        }
        char c = word.charAt(index);
        if (c != '.') {
            return search(trie.nodes[c - 'a'], word, index + 1);
        } else {
            for (Trie node : trie.nodes) {
                if (node != null) {
                    if (search(node, word, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}

// Your solution.WordDictionary object will be instantiated and called as such:
// solution.WordDictionary wordDictionary = new solution.WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

