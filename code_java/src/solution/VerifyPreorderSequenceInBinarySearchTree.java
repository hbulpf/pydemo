package solution;

public class VerifyPreorderSequenceInBinarySearchTree {

    public boolean verifyPreorder(int[] preorder) {
        return verifyPreorder(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return true;
        }

        int i = start + 1;
        for ( ; i <= end; i++) {
            if (preorder[i] > preorder[start]) {
                break;
            }
        }
        for (int j = i; j <= end; j++) {
            if (preorder[j] <= preorder[start]) {
                return false;
            }
        }
        return verifyPreorder(preorder, start + 1, i - 1) && verifyPreorder(preorder, i, end);
    }
}
