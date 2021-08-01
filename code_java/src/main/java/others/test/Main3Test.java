package others.test;

import org.junit.Test;
import others.chrysanthemum.Main3;

/**
 * 运动会，任意3排，抽方阵
 *
 */
public class Main3Test {

    Main3 main3 = new Main3();

    @Test
    public void numWay() {
        String[] grid = new String[] {"alb", "gkl", "fda", "del"};
        int res = main3.numWay(grid);
        System.out.println(res);
        grid = new String[] {"aaa","aaa","aaa"};
        res = main3.numWay(grid);
        System.out.println(res);
        grid = new String[] {"aab","aaa","baa"};
        // grid = new String[] {"baa","aaa","aab"};
        res = main3.numWay(grid);
        System.out.println(res);

        grid = new String[] {"aaa","aaa","aaa","aaa"};
        res = main3.numWay(grid);
        System.out.println(res);
    }

    @Test
    public void getNum() {
        String[] grid = new String[] {"alb", "fda", "del"};
        int res = main3.getNum(grid);
        System.out.println(res);
    }

    @Test
    public void checkMatrix() {
    }
}
