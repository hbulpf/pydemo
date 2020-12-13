package solution;

import java.util.HashSet;

/**
 * 单词接龙，前一个单词的尾巴和后一个单词的头相同就算接上了
 * 如果要返回接龙的结果，可以给HashSet改成List
 * 如果要返回所有可能的结果呢？
 */
public class CanArrangeWords {

    public static boolean canArrangeWords(String[] words) {
        HashSet<String> set = new HashSet<String>();
        return helper(null, words, set);
    }

    public static boolean helper(String word, String[] words, HashSet<String> set) {
        if (set.size() == words.length) {
            return true;
        }

        for (String s : words) {
            if (!set.contains(s) && (word == null || s.charAt(0) == word.charAt(word.length() - 1))) {
                set.add(s);
                if (helper(s, words, set)) {
                    return true;
                }
                set.remove(s);
            }
        }
        return false;
    }
}
