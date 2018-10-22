package com.codergray.lab.fetchr;

import java.util.LinkedList;
import java.util.Queue;

//求二叉树 distance 
//output largest distance
public class MaxTreeDistance {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        TreeNode node1 = new TreeNode(1);
        System.out.println(maxDistance(node1) == 0);

        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(maxDistance(node1) == 1);

        TreeNode node3 = new TreeNode(3);
        node1.right = node3;
        System.out.println(maxDistance(node1) == 2);

        TreeNode node4 = new TreeNode(4);
        node3.left = node4;
        TreeNode node5 = new TreeNode(5);
        node3.right = node5;
        TreeNode node6 = new TreeNode(6);
        node5.right = node6;
        TreeNode node7 = new TreeNode(7);
        node6.right = node7;
        TreeNode node8 = new TreeNode(8);
        node4.left = node8;
        TreeNode node9 = new TreeNode(9);
        node8.left = node9;
        TreeNode node10 = new TreeNode(10);
        node9.left = node10;
        System.out.println(maxDistance(node1) == 7);

    }

    private static int maxDistance(TreeNode node){
        if(node == null){
            return 0;
        }

        int max = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            TreeNode root = queue.poll();
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            if(left + right > max){
                max = left + right;
            }
            if(root.left != null){
                queue.offer(root.left);
            }

            if(root.right != null){
                queue.offer(root.right);
            }
        }

        return max;
    }

    private static int getDepth(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = getDepth(node.left);
        int right = getDepth(node.right);

        return 1 + Math.max(left, right);
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}