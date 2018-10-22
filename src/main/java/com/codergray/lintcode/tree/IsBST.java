package com.codergray.lintcode.tree;

/**
 * Created by cwang on 3/10/17.
 */
public class IsBST {
    static boolean checkBST(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        boolean isLeftBST;
        boolean isRightBST;
        isLeftBST = isBST(root.left, min, root.val);
        if(root.left!=null){
            isLeftBST = isLeftBST && root.val>root.left.val;
        }
        isRightBST = isBST(root.right, root.val, max);
        if(root.right!=null){
            isRightBST = isRightBST && root.val<root.right.val;
        }
        return isLeftBST && isRightBST;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node3.left = node2;
        node2.left = node1;
        node3.right = node5;
        node5.left = node4;
        node5.right = node6;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;

        System.out.println(checkBST(node3));
    }
}
