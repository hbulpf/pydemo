package others.test;

import org.junit.Assert;
import org.junit.Test;
import others.chrysanthemum.Main2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 十进制整数数组，按位与操作
 */
public class Main2Test {
    Main2 main2 = new Main2();

    private static void print(int[] in) {
        for (int i : in) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    @Test
    public void findMaxValuePosition() {
        int[] t1 = new int[] {23, 12, 10, 8, 7, 45, 16};
        int[] res = main2.findMaxValuePosition(t1);
        Assert.assertArrayEquals(new int[] {0, 6}, res);
        print(res);
        t1 = new int[] {44, 12, 52, 38, 16};
        res = main2.findMaxValuePosition(t1);
        Assert.assertArrayEquals(new int[] {0, 2}, res);
        print(res);
    }

    @Test
    public void calAnd() {
        int r1 = main2.calAnd(1, 0);
        System.out.println(r1);
        int r2 = main2.calAnd(44, 52);
        System.out.println(r2);
        r2 = main2.calAnd(23, 16);
        System.out.println(r2);
        r2 = main2.calAnd(45, 23);
        System.out.println(r2);
    }

    @Test
    public void testSeq() {
        int[][] input = new int[][] {{0, 1}, {0, 2}, {1, 2}, {1, 3}};
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            res.add(main2.calAnd(input[i][0], input[i][1]));
        }
        System.out.println(res);
    }

    @Test
    public void testArr() {
        int[] t1 = new int[] {23, 12, 10, 8, 7, 45, 16};
        int res = 23;
        for (int i = 0; i < t1.length; i++) {
            res &= t1[i];
        }
        System.out.println(res);

        Arrays.sort(t1);
        print(t1);
    }
}
