package com.lc.practice.datastructure;

import lombok.Data;

/**
 * Definition for a binary tree node.
 */
@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){};
    public TreeNode(int val) {this.val = val;}
    TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
