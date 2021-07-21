package com.lc.practice.datastructure;

import lombok.Data;

import java.util.List;

/**
 * N Tree Node
 */
@Data
public class Node {
    public int val;
    public List<Node> children;

    public Node(){}
    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
