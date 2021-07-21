package com.lc.practice.datastructure;

import lombok.Data;

@Data
public class PerfectNode {
    int val;
    PerfectNode left;
    PerfectNode right;
    PerfectNode next;

    public PerfectNode() {
    }

    public PerfectNode(int val) {
        this.val = val;
    }

    public PerfectNode(int val, PerfectNode left, PerfectNode right, PerfectNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
