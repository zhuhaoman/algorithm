package com.lc.practice.tree;

import com.lc.practice.datastructure.Node;
import com.lc.practice.datastructure.PerfectNode;
import com.lc.practice.datastructure.TreeNode;

import java.util.*;

import static java.lang.Integer.*;

/**
 * 二叉树层级遍历
 *
 * 二叉树层级遍历需借助队列来实现
 */
public class LevelOrder {
    /**
     * 二叉树的层序遍历
     *
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * @link https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                values.add(tree.getVal());
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
            result.add(values);
        }
        //@link https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
        List<Integer> temp;
        int length = result.size();
        for (int i = 0; i < length/2; i++) {
            temp = result.get(i);
            result.set(i,result.get(length - i));
            result.set(length - i, temp);
        }
        return result;

    }

    /**
     * 二叉树的右视图
     *
     * 将每一层的最后一个数据放入结果中
     * @link https://leetcode-cn.com/problems/binary-tree-right-side-view/
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                if (i == size - 1) result.add(tree.getVal());
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
        }
        return result;
    }

    /**
     * 二叉树的层平均值
     *
     * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
     * @link https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
     * @param root
     * @return
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                sum += tree.getVal();
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
            sum = sum/size;
            result.add(sum);
        }
        return result;
    }

    /**
     * N 叉树的层序遍历
     *
     * @link https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node tree = queue.pollFirst();
                values.add(tree.val);
                List<Node> children = tree.getChildren();
                children.forEach(child -> queue.add(child));
            }
            result.add(values);
        }
        return result;
    }

    /**
     * 在每个树行中找最大值
     *
     * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
     * @link https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                max = max < tree.getVal() ?  tree.getVal() : max;
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
            result.add(max);
        }
        return result;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @link https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     * @param root
     * @return
     */
    public PerfectNode connect(PerfectNode root) {
        if (root == null) return null;
        Deque<PerfectNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                PerfectNode node = queue.poll();
                if (i < size - 1) {
                    node.setNext(queue.peek());
                }
                if (node.getLeft() != null) queue.add(node.getLeft());
                if (node.getRight() != null) queue.add(node.getRight());
            }
        }
        return root;
    }

    /**
     * 填充每个节点的下一个右侧节点指针
     *
     * @link https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     * @param root
     * @return
     */
    public PerfectNode connect1(PerfectNode root) {
        if (root == null) return null;

        PerfectNode leftMost = root;
        while (leftMost.getLeft() != null) {
            PerfectNode head = leftMost;
            while (head != null) {
                head.getLeft().setNext(head.getRight());
                if (head.getNext() != null) {
                    head.getRight().setNext(head.getNext().getLeft());
                }
                head = head.getNext();
            }

            leftMost = leftMost.getLeft();
        }
        return root;
    }

    /**
     * 二叉树的最大深度 (迭代)
     *
     * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public int maxDepthByIterator(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
            maxDepth++;
        }
        return maxDepth;
    }

    /**
     * 二叉树的最大深度 (递归)
     *
     * @link https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.getLeft()),maxDepth(root.getRight()));
    }

    /**
     * 二叉树的最小深度 (迭代)
     *
     * @link https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
     * @param root
     * @return
     */
    public int minDepthByIterator(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                if (tree.getLeft() == null && tree.getRight() == null) return minDepth;
                if (tree.getLeft() != null) queue.add(tree.getLeft());
                if (tree.getRight() != null) queue.add(tree.getRight());
            }
        }
        return minDepth;
    }

    /**
     * 二叉树的最小深度 (递归)
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.getLeft() == null && root.getRight() == null) return 1;

        int minDepth = MAX_VALUE;
        if (root.getLeft() != null) {
            minDepth = Math.min(minDepth(root.getLeft()) ,minDepth) ;
        }
        if (root.getRight() != null) {
            minDepth = Math.min(minDepth(root.getRight()) , minDepth);
        }
        return minDepth + 1;
    }

    /**
     * 对称二叉树
     *
     * @param root
     * @return
     * @link https://leetcode-cn.com/problems/symmetric-tree/
     */
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root,root);
    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.getVal() == right.getVal() && isEqual(left.getLeft(),right.getRight()) && isEqual(left.getRight(),right.getLeft());
    }

    /**
     * 路径总和
     *
     * @link https://leetcode-cn.com/problems/path-sum/
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        //终止条件
        if (root.getLeft() == null && root.getRight() == null) {
            return root.getVal() == sum;
        }

        return hasPathSum(root.getLeft(), sum - root.getVal()) || hasPathSum(root.getRight(), sum - root.getVal());
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) return false;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Deque<Integer> nodeValues = new LinkedList<>();
        nodeValues.add(root.getVal());

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode tree = queue.pollFirst();
                Integer value = nodeValues.pollFirst();
                if (tree.getLeft() == null && tree.getRight() == null) {
                    if(sum == value) return true;
                    continue;
                }

                if (tree.getLeft() != null) {
                    queue.add(tree.getLeft());
                    nodeValues.add(value + tree.getLeft().getVal());
                }
                if (tree.getRight() != null) {
                    queue.add(tree.getRight());
                    nodeValues.add(value + tree.getRight().getVal());
                }
            }
        }
        return false;
    }



}
