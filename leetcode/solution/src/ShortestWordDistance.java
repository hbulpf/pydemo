public class ShortestWordDistance {

    // 耗时3ms
    public int shortestDistance(String[] words, String word1, String word2) {
        int l1 = -1, l2 = -1, shortest = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                l1 = i;
            } else if (words[i].equals(word2)) {
                l2 = i;
            } else {
                continue;
            }
            if (l1 >= 0 && l2 >= 0) {
                shortest = Math.min(shortest, Math.abs(l1 - l2));
            }
        }
        return shortest;
    }
}
