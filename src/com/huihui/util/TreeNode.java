package com.huihui.util;

import Ch101_120.Ch105;
import Ch101_120.Ch108;

/**
 * Created by hadoop on 2015/6/3 0003.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static void printPreorder(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + ",");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + ",");
        printInorder(node.right);
    }

    public static void printPoster(TreeNode node) {
        if (node == null)
            return;
        printPoster(node.left);
        printPoster(node.right);
        System.out.print(node.val + ",");
    }

    public static TreeNode sortedArrayToBST(int n) {
        int[] nums = new int[n];
        for(int i=1;i<=n;i++){
            nums[i-1] = i;
        }
        return new Ch108().sortedArrayToBST(nums);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return new Ch105().buildTree(preorder, inorder);
    }


}
