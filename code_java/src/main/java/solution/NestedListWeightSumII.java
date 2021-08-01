package solution;

import common.enties.NestedInteger;

import java.util.List;

/**
 * https://leetcode.com/articles/nested-list-weight-sum/
 */
public class NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depth = calcDepth(nestedList);
        return depthSumInverse(nestedList, depth);
    }

    public int calcDepth(List<NestedInteger> nestedList) {
        int max = 0;

        for (NestedInteger nest : nestedList) {
            if (!nest.isInteger()) {
                int depth = calcDepth(nest.getList());
                max = Math.max(depth + 1, max);
            } else {
                max = Math.max(max, 1);
            }
        }

        return max;
    }

    private int depthSumInverse(List<NestedInteger> nestedList, int depth) {
        int sum = 0;

        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                sum += depth * nest.getInteger();
            } else {
                sum += depthSumInverse(nest.getList(), depth - 1);
            }
        }

        return sum;
    }

    /**
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> niList, int prev) {
        int intSum = prev;
        List<NestedInteger> levelBreak = new ArrayList<>();

        for (NestedInteger ni : niList) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                levelBreak.addAll(ni.getList());
            }
        }

        // 要判断levelBreak为空，否则会死循环
        int listSum = levelBreak.isEmpty() ? 0 : helper(levelBreak, intSum);

        return listSum + intSum;
    }
     */
}
