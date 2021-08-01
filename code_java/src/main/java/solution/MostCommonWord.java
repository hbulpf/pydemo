package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {

    /**
     * 要注意结尾的单词
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> bannes = new HashSet<>(Arrays.asList(banned));

        String result = null;
        int count = 0;

        boolean enterWord = false;
        for (int i = 0, j = 0; j <= paragraph.length(); j++) {
            char c = j < paragraph.length() ? paragraph.charAt(j) : '.';
            if (Character.isAlphabetic(c)) {
                if (!enterWord) {
                    enterWord = true;
                    i = j;
                }
            } else {
                if (enterWord) {
                    enterWord = false;
                    String word = paragraph.substring(i, j).toLowerCase();
                    if (!bannes.contains(word)) {
                        int cnt = map.getOrDefault(word, 0) + 1;
                        map.put(word, cnt);

                        if (cnt > count) {
                            count = cnt;
                            result = word;
                        }
                    }
                }
            }
        }

        return result;
    }
}
