/**
 * N株植物，补充1升水
 *
 */
public class Main1Test {
    Main1 main1 = new Main1();

    @Test
    public void minOperations() {
        int[] t = new int[] {3, 1, 9, 10};
        int res = main1.minOperations(t, 3);
        System.out.println(res);

        t = new int[] {5, 3, 10, 5};
        res = main1.minOperations(t, 2);
        System.out.println(res);

        t = new int[] {5, 3, 10, 5};
        res = main1.minOperations(t, 0);
        System.out.println(res);

        t = new int[] {};
        res = main1.minOperations(t, 2);
        System.out.println(res);

        System.out.println("max:" + Math.pow(2,32));
    }
}
