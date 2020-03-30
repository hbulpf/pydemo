package solution;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] mNums;
    private Random mRandom;

    public ShuffleAnArray(int[] nums) {
        mNums = nums;
        mRandom = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return mNums;
    }

    /** Returns a random shuffling of the array. */
    /**
     * 注意这里生成随机数时的范围是i+1，就是[0,i]
     * 我们要确保[0,j]范围内的数在j的概率都是一样的，即1/(j+1)
     * 假如生成的随机数是j，则显然概率是1/(j+1)
     * 假如随机数不是j，则在[0,j-1]中，swap到j，概率是(1-1/(j+1))*1/j=1/(j+1)
     */
    public int[] shuffle() {
        int[] array = Arrays.copyOf(mNums, mNums.length);
        for (int i = 1; i < array.length; i++) {
            int index = mRandom.nextInt(i + 1);
            swap(array, i, index);
        }
        return array;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
