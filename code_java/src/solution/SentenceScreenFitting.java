package solution;

/**
 * https://discuss.leetcode.com/category/546/sentence-screen-fitting
 */
public class SentenceScreenFitting {

    /**
     * https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution/2
     * 这道题思路是将这个句子按空格拼接起来，然后铺开，这里核心是start，表示对应的循环铺开序列的索引，
     * 注意每行的开头一定要对应某个单词的第一个字符，所以如果不是的话需要调整start
     * 假如单词拼接为"abc de f "，注意结尾加了空格，铺开后为"abc de f abc de f abc de f abc de f ..."
     * start起始为0，下一行需要start+col，如果对到了空格则需要start++，因为每行起始不能是空格，
     * 如果对到了字母，但是不是单词的第一个字母，则要start--，因为单词是不能分裂到多行的，所以每行起始
     * 必须是单词的第一个字符。这样一直算到screen最后一行的下一行的起始，所以整个screen所能容纳的有效区间为[0, start),
     * 即长度为start，对应到铺开序列中，我们可以算出一共有几个循环，就表示单词能出现的次数了。
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), start = 0;
        for ( ; rows > 0; rows--) {
            start += cols;
            if (s.charAt(start % len) == ' ') {
                start++;
            } else {
                for ( ; start > 0 && s.charAt((start - 1) % len) != ' '; start--);
            }
        }
        return start / len;
    }

    /** 常规做法，超时了，O(mn)
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0, idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; ) {
                j += sentence[idx].length();

                if (j <= cols) {
                    j++;
                    if (++idx >= sentence.length) {
                        idx = 0;
                        count++;
                    }
                }
            }
        }
        return count;
    }*/
}
