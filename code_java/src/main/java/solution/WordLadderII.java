package solution;

import java.util.*;

/**
 * TestCases
 * "a", "c", ["a", "b", "c"]
 * "hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]
 * "hit", "cog", ["hot","hit","cog","dot","dog"]
 * "red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
 */
public class WordLadderII {

    /**
     * 这题核心就是保存前驱节点
     */

    /**
     * 保存前驱节点
     */
    class WordNode {
        String word;
        WordNode prev;

        public WordNode(String word, WordNode pre) {
            this.word = word;
            this.prev = pre;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> next = new LinkedList<>();
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, null));

        // 假如dict中有start则删掉
        wordList.remove(beginWord);
        wordList.add(endWord);

        HashSet<String> visited = new HashSet<String>();

        while (!queue.isEmpty()) {
            WordNode top = queue.poll();
            String word = top.word;

            if (word.equals(endWord)) {
                ArrayList<String> t = new ArrayList<String>();
                for (WordNode p = top; p != null; p = p.prev) {
                    /**
                     * 注意这里是逆序添加
                     */
                    t.add(0, p.word);
                }
                result.add(t);
                /**
                 * 这里continue了，继续查看本层其它节点
                 */
                continue;
            }

            /**
             * 这里非常关键，result非空表示已经找到了一条最短路径，则当前层就是最短的了，给当前层遍历完毕就OK了
             * 而queue是空则表示当前层已经遍历完毕了
             */
            if (!result.isEmpty() && queue.isEmpty()) {
                break;
            }

            /**
             * 这里可以优化一下，如果wordList为空，则这个for循环是没有意义的
             */
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                for (int j = 0; j < 26; j++) {
                    if ('a' + j == c) {
                        continue;
                    }
                    sb.setCharAt(i, (char) ('a' + j));
                    String newWord = sb.toString();
                    if (wordList.contains(newWord)) {
                        /**
                         * 这里同一个单词可能会重复添加，对应着多条路径
                         */
                        next.add(new WordNode(newWord, top));
                        visited.add(newWord);
                    }
                }
                sb.setCharAt(i, c);
            }

            if (queue.isEmpty()) {
                queue.addAll(next);
                next.clear();
                /**
                 * 只有本层都走完了才能将访问过的word从dict中删除，因为同一层同一个单词可能会被多次利用
                 * 比如上一层的dot和hog都能对应到本层的hot，那么hot就要重复利用，对应着两条路径
                 */
                wordList.removeAll(visited);
            }
        }

        return result;
    }
}
