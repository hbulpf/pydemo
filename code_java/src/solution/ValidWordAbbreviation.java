public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        for (int value = 0; i < word.length() && j < abbr.length(); ) {
            if (word.charAt(i) == abbr.charAt(j)) {
                i++; j++;
                continue;
            }

            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            for (value = 0; j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'; j++) {
                value = value * 10 + (abbr.charAt(j) - '0');
            }
            i += value;
        }
        return i == word.length() && j == abbr.length();
    }
}
