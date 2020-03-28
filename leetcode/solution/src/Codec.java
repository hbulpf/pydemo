import java.util.*;

/**
 * 类似题
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */

/**
 * 要注意的是分隔符不要加重复了，比如1,X,,X这样的，重复的话在split时会有空串
 * 分递归版和非递归版，递归版的如果树大了可能栈溢出
 */
public class Codec {
    // 这里的分隔符是有讲究的，如果换成'.'则在split的时候要转义，但是','不用
    private static final String SEP = ",";

    // 这个尽可能短，节省空间
    private static final String NULL = "X";

    /** 递归版的 */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root != null) {
            sb.append(root.val).append(SEP);
            sb.append(serialize(root.left)).append(SEP);
            sb.append(serialize(root.right));
        } else {
            sb.append(NULL);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] texts = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(texts));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String text = queue.poll();
        if (text.equals(NULL)) {
            return null;
        }
        int val = Integer.valueOf(text);
        TreeNode root = new TreeNode(val);
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

    /** 下面是非递归版的，前序遍历 */
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NULL);
            return sb.toString();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                sb.append(root.val);
                stack.push(root);
                root = root.left;
            } else {
                sb.append(NULL);
                root = stack.pop().right;
            }

            sb.append(SEP);
        }
        return sb.toString();
    }

    /**
     * 前序访问一遍所有结点
     * 在设置node时，从queue中取出值
     */
    public TreeNode deserialize2(String data) {
        String[] texts = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(texts));
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = getNode(queue), node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node.left = getNode(queue);
                node = node.left;
            } else {
                node = stack.pop();
                node.right = getNode(queue);
                node = node.right;
            }
        }

        return root;
    }

    private TreeNode getNode(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String text = queue.poll();
        if (text.equals(NULL)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(text));
    }

    /**
     * BFS版的
     */
    public String serialize3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append(NULL);
            return sb.toString();
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(node.val).append(SEP);
            queue.add(node.left);
            queue.add(node.right);
        }
        return sb.toString();
    }

    public TreeNode deserialize3(String data) {
        String[] text = data.split(SEP);
        Queue<String> queue = new LinkedList<String>(Arrays.asList(text));

        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        TreeNode root = getNode(queue);
        queue2.add(root);

        while (!queue2.isEmpty()) {
            TreeNode node = queue2.poll();

            if (node == null) {
                continue;
            }

            node.left = getNode(queue);
            queue2.add(node.left);

            node.right = getNode(queue);
            queue2.add(node.right);
        }

        return root;
    }
}
