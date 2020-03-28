public class PaintHouse {

    public int minCost(int[][] costs) {
        int[] f = new int[3];
        int f0 = 0, f1 = 0, f2 = 0;
        for (int i = 0; i < costs.length; i++) {
            f[0] = costs[i][0] + Math.min(f1, f2);
            f[1] = costs[i][1] + Math.min(f0, f2);
            f[2] = costs[i][2] + Math.min(f0, f1);
            f0 = f[0]; f1 = f[1]; f2 = f[2];
        }
        return Math.min(Math.min(f0, f1), f2);
    }
}
