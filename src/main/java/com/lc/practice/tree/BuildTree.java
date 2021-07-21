package com.lc.practice.tree;

import com.lc.practice.datastructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树构造
 */
public class BuildTree {
    Map<Integer, Integer> indexMap = new HashMap<>();
    int rootIndex;

    /**
     * 从中序与后序遍历序列构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     * @link https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo98qt/
     *
     * 从前序与中序遍历序列构造二叉树
     * @link https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //后序遍历数组长度
        int length = postorder.length - 1;
        //根节点位置
        rootIndex = length;
        int index = 0;
        //将inorder转为map，获取下标
        for (Integer val : inorder) {
            indexMap.put(val, index++);
        }
        return helper(postorder, 0, length);
    }

    //构建树
    private TreeNode helper(int[] postorder, int in_left, int in_right) {
        if (in_left > in_right) return null;
        int rootValue = postorder[rootIndex];
        int middle = indexMap.get(rootValue);

        rootIndex--;
        //根节点
        TreeNode root = new TreeNode(rootValue);
        root.setRight(helper(postorder,middle + 1, in_right));
        root.setLeft(helper(postorder,in_left,middle-1));
        return root;
    }


}
