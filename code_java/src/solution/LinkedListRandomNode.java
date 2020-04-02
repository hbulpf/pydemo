package solution;

import java.util.Random;

public class LinkedListRandomNode {

    private Random mRandom;
    private ListNode mHead;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        mRandom = new Random();
        mHead = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int count = 0;

        int value = -1;

        for (ListNode p = mHead; p != null; p = p.next) {
            if (mRandom.nextInt(++count) == 0) {
                value = p.val;
            }
        }

        return value;
    }
}
