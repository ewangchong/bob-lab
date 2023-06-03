package com.codergray.lintcode.tree;

/**
 * Created by cwang on 2/23/17.
 */
public class MaximumSubTree {
    public TreeNode result = null;
    public int MAX_WEIGHT = Integer.MIN_VALUE;

    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        sum(root);
        return result;
    }

    private int sum(TreeNode node) {
        if (null == node)
            return 0;

        int left_sum = sum(node.left);
        int right_sum = sum(node.right);

        if (result == null || left_sum + right_sum + node.val > MAX_WEIGHT) {
            MAX_WEIGHT = left_sum + right_sum + node.val;
            result = node;
        }
        return left_sum + right_sum + node.val;
    }
}
