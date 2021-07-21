package com.lc.practice.tree;

import com.lc.practice.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class InOrder {
    /**
     * Solution 1：递归
     *
     * *复杂度分析
     *      时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     *      空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     *
     * @param root
     * @return
     */
    public List<Integer> inrOderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();

        if (root == null) return result;
        inrOderTraversal(root.getLeft());
        result.add(root.getVal());
        inrOderTraversal(root.getRight());
        return result;
    }

    /**
     * Solution 2：迭代遍历二叉树
     * *思路：
     *      方法一的递归函数我们也可以用迭代的方式实现，两种方式是等价的，
     *      区别在于递归的时候隐式地维护了一个栈，在迭代的时候需要显式地将这个栈模拟出来。
     *
     * *复杂度分析：
     *     时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     *     空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     *
     * @param root
     * @return
     */
    public List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.getLeft();
            }
            root = stk.pop();
            res.add(root.getVal());
            root = root.getRight();
        }
        return res;
    }


}
