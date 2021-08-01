package solution;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToHireKWorkers {

    class Man {
        int quality;
        int wage;

        Man(int a, int b) {
            quality = a;
            wage = b;
        }

        double ratio() {
            return (double) wage / quality;
        }
    }

    /**
     * 这题意思是选取K个工人，保证付给他们的工资和quality的比例都是一样的，且不低于他们的期望工资，问最少付的工资是多少
     * 定义性价比为wage/quality，这个值越小表示性价比越高
     * 将所有工人按性价比排序，显然要少付工资，当然尽可能选取更多的高性价比工人
     * 为了满足所有人工资和quality比例都一样，这个比例显然是所选的K个工人中性价比最低的那个
     * 不能完全按性价比来，因为可能存在的情况是高性价比quality也高，在ratio一定的情况下，要付出的总工资也多
     * 所以要对性价比从高到低地遍历工人，边遍历边当满足K个人数的时候计算要付出的工资，人数超的时候踢掉quality最高的那个人，因为越往后遍历ratio越大，那么总体的quality
     * 要尽可能小才行
     */
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Queue<Man> queue = new PriorityQueue<>(new Comparator<Man>() {
            @Override
            public int compare(Man o1, Man o2) {
                return o1.ratio() > o2.ratio() ? 1 : -1;
            }
        });
        for (int i = 0; i < quality.length; i++) {
            queue.offer(new Man(quality[i], wage[i]));
        }
        double money = Integer.MAX_VALUE, qsum = 0;
        Queue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        while (!queue.isEmpty()) {
            Man man = queue.poll();
            qsum += man.quality;
            queue2.offer(man.quality);
            if (queue2.size() > K) {
                qsum -= queue2.poll();
            }
            if (queue2.size() == K) {
                money = Math.min(money, qsum * man.ratio());
            }
        }
        return money;
    }
}
