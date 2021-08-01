package common.enties;

public class TrieNode {

    public TrieNode[] nodes;

    public String word;

    public TrieNode() {
        nodes = new TrieNode[26];
    }
}
