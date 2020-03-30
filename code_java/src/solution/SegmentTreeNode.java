public class SegmentTreeNode {

    public SegmentTreeNode left, right;

    public int sum;

    public int start, end;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
