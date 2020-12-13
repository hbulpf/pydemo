package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessTheWord {

    public interface Master {
        int guess(String word);
    }

    /**
     * 这题的意思是有一个word列表，取其中一个作为secret，现在让你来猜哪个是secret，最多猜10次，
     * 你每猜一个单词，就告诉你这个单词和secret匹配的字母数。
     * 这里的思路很直接，就是随机取一个单词开始，获得了匹配的字母数后在单词列表中找到可能的候选项
     * 然后再迭代一次，这样猜10次
     */
    public void findSecretWord(String[] wordlist, Master master) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String word = wordlist[random.nextInt(wordlist.length)];
            int match = master.guess(word);
            List<String> list = new ArrayList<>();
            for (String s : wordlist) {
                if (match(s, word) == match) {
                    list.add(s);
                }
            }
            wordlist = list.toArray(new String[0]);
        }
    }

    private int match(String s, String t) {
        int match = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                match++;
            }
        }
        return match;
    }
}
