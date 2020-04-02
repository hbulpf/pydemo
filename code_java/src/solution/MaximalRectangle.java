package solution;

public abstract class MaximalRectangle {

    // 耗时10ms，时间复杂度是O(mn)，空间复杂度O(n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int row = matrix.length, col = matrix[0].length, max = 0;
        int[] heights = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

    // 耗时9ms
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int row = matrix.length, col = matrix[0].length, area = 0;
        int[] height = new int[col], left = new int[col], right = new int[col];
        for (int i = 0; i < col; right[i] = col - 1, i++);

        for (int i = 0; i < row; i++) {
            int leftStart = 0, rightStart = col - 1;

            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    height[j] = 0;
                } else {
                    height[j]++;
                }
            }

            // 注意当matrix[i][j]为0时其实left[j]和right[j]是多少已经不重要了，因为
            // height[j]为0，所以这里算left[j]和right[j]只是为了方便计算下一层
            // 所以left[j]=0好理解，而right[j]=col-1的目的是为了设置成最大的，因为下一层要求min

            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '0') {
                    left[j] = 0;
                    leftStart = j + 1;
                } else {
                    left[j] = Math.max(left[j], leftStart);
                }
            }

            for (int j = col - 1; j >= 0; j--) {
                // 注意这里不是0，而是字符'0'
                if (matrix[i][j] == '0') {
                    right[j] = col - 1;
                    rightStart = j - 1;
                } else {
                    right[j] = Math.min(right[j], rightStart);
                }
            }

            for (int j = 0; j < col; j++) {
                area = Math.max(area, (right[j] - left[j] + 1) * height[j]);
            }
        }

        return area;
    }

    abstract int largestRectangleArea(int[] heights);
}
