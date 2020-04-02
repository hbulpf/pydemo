package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class BullsAndCows {

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
