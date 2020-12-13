package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 299. 猜数字游戏
 *
 * @Author: RunAtWorld
 * @Date: 2020/5/13 22:41
 */
public class BullsAndCows {

    /**
     * 暴力法
     * T=O(N)=2*N
     * S=O(N)
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint1(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> secretMap = new HashMap();
        Map<Character, Integer> guessMap = new HashMap();
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretMap.put(secret.charAt(i), secretMap.getOrDefault(secret.charAt(i), 0) + 1);
                guessMap.put(guess.charAt(i), guessMap.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : guessMap.entrySet()) {
            cows += Math.min(entry.getValue(), secretMap.getOrDefault(entry.getKey(), 0));
        }
        return bulls + "A" + cows + "B";
    }

    /**
     * 优化的暴力法:把HashMap换成数组
     * T=O(N)=2*N
     * S=O(N)
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint2(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] secretMap = new int[10];
        int[] guessMap = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                secretMap[secret.charAt(i) - '0']++;
                guessMap[guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretMap[i], guessMap[i]);
        }
        return bulls + "A" + cows + "B";
    }


    /**
     * 使用数组临时存cows+
     * T=O(N)
     * S=O(1)
     *
     * @param secret
     * @param guess
     * @return
     */
    public String getHint3(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';
                //如果secret的字符在guess中
                if (numbers[s] < 0) {
                    cows++;
                }
                //如果guess的字符在secret中
                if (numbers[g] > 0) {
                    cows++;
                }
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public String getHint(String secret, String guess) {
        HashMap<Character, Set<Integer>> map1 = new HashMap<>();
        HashMap<Character, Set<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            Set<Integer> set = map1.getOrDefault(secret.charAt(i), new HashSet<>());
            set.add(i);
            map1.put(secret.charAt(i), set);
        }
        for (int i = 0; i < guess.length(); i++) {
            Set<Integer> set = map2.getOrDefault(guess.charAt(i), new HashSet<>());
            set.add(i);
            map2.put(guess.charAt(i), set);
        }
        int bulls = 0, cows = 0;
        for (Character c : map2.keySet()) {
            Set<Integer> set1 = map1.get(c);

            if (set1 == null) {
                continue;
            }

            Set<Integer> set2 = map2.get(c);

            int count = 0;

            for (Integer index : set2) {
                if (set1.contains(index)) {
                    count++;
                }
            }

            bulls += count;
            cows += Math.min(set1.size(), set2.size()) - count;
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
