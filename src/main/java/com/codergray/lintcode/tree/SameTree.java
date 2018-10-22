package com.codergray.lintcode.tree;

public class SameTree {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(0);

		System.out.println(SameTree.isSameTree(p, q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else
			return false;
	}
}
