import java.util.LinkedList;
import java.util.List;

/**
 * 这题应该多做几遍，没什么技巧，就是考码代码能力
 * 类似题目为https://leetcode.com/problems/sentence-screen-fitting/
 */

/**
 * TestCases
 * "", 0
 * ["a","b","c","d","e"], 3
 */

/**
 * 这题有几个条件，
 * 如果一行只有一个单词或者该行是最后一行，则往左靠
 * 其余情况则往两边撑满，中间均衡地填充空格，如果不能均衡，则左边优先
 */
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<String>();

        int count, last;
        for (int first = 0; first < words.length; first = last) {
            for (last = first, count = 0; last < words.length; last++) {
                if (count + words[last].length() + last - first > maxWidth) {
                    break;
                }
                count += words[last].length();
            }
            StringBuilder sb = new StringBuilder();

            // 最后一行或者一行只有一个单词的情况
            if (last == words.length || last - first == 1) {
                for (int i = first; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                // 这里给最后的空格去掉是避免最后的空格导致超出
                sb.deleteCharAt(sb.length() - 1);
                for ( ; sb.length() < maxWidth; sb.append(" "));
            } else {
                int spaces = maxWidth - count;
                int avg = spaces / (last - first - 1);
                int extraSpaces = spaces - avg * (last - first - 1);
                for (int i = first; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) { // 注意这里别掉了，最后一个单词后是不跟空格的
                        int curSpaces = avg + (extraSpaces > 0 ? 1 : 0);
                        for (int j = 0; j < curSpaces; j++) {
                            sb.append(" ");
                        }
                        extraSpaces--;
                    }
                }
            }

            result.add(sb.toString());
        }

        return result;
    }
}
