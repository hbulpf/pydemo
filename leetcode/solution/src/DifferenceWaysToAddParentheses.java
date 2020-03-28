import java.util.ArrayList;
import java.util.List;

public class DifferenceWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();

        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);

            if ("+-*".indexOf(c) >= 0) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));

                for (Integer m : left) {
                    for (Integer n : right) {
                        switch (c) {
                            case '+': result.add(m + n); break;
                            case '-': result.add(m - n); break;
                            case '*': result.add(m * n); break;
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.valueOf(input));
        }

        return result;
    }
}
