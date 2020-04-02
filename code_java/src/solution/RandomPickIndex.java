package solution;

import java.util.Random;

/**
 * 注意这里一定要给整个数组遍历完，这样才能保证所有数字的概率是一样的，否则只能保证
 * 当前遍历过的数都是等概率的。
 */

/**
 * 这道题涉及到reservoir sampling，就是从n个数中随机抽取k个数，要保证每个数都是等概率的。
 * 做法是维护一个大小为k的池子，当池子还没装满时，不停的往里装，当池子装满后，就要考虑是用新数替换池子中旧的
 * 数，还是丢弃新数。现在的问题是来了一个新数，这个数的编号是x，那么该怎么做呢？
 * 我们首先以k / x的概率来决定是否保存新数，即生成一个[0,1)之间的数，如果小于k/x，则保留新数，同时随机
 * 替换掉池子中的一个数。如果大于k/x，则丢弃新数。
 */

/**
 * 本题是随机抽取一个数，所以是否保留当前数就看random的结果是否小于1，即为0。如果为0，则替换掉。
 */

/**
 * 类似的题还有从文件中随机读取一行，如果是流数据中随机取则到当前为止就好了，如果是数组或链表这种固定数据中随机取，
 * 则有遍历完才能返回。类似的题目可参考https://leetcode.com/problems/linked-list-random-node/
 */
public class RandomPickIndex {

    private Random mRandom;
    private int[] mNums;

    public RandomPickIndex(int[] nums) {
        mRandom = new Random();
        mNums = nums;
    }

    public int pick(int target) {
        int count = 0;

        int result = -1;

        for (int i = 0; i < mNums.length; i++) {
            if (mNums[i] == target && mRandom.nextInt(++count) == 0) {
                /**
                 * 这里只是暂时替换掉result，不能返回。result相当于大小为1的池子
                 */
                result = i;
            }
        }

        return result;
    }
}
