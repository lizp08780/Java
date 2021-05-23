package com.lizp.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution5 {
    public static List<Integer> midOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    public static void midOrder2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            midOrder2(root.left, list);
            list.add(root.val);
            midOrder2(root.right, list);
        }
    }

    public static void preOrder2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            list.add(root.val);
            preOrder2(root.left, list);
            preOrder2(root.right, list);
        }
    }

    public static List<Integer> preOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return list;
    }

    public static List<Integer> proOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> src = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        src.push(root);
        while (!src.isEmpty()) {
            TreeNode p = src.pop();
            res.push(p);
            if (p.left != null) {
                src.push(p.left);
            }
            if (p.right != null) {
                src.push(p.right);
            }
        }
        //输出最终后序遍历的结果
        while (!res.isEmpty()) {
            list.add(res.pop().val);
        }
        return list;
    }

    public static void proOrder2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            proOrder2(root.left, list);
            proOrder2(root.right, list);
            list.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node4 = new TreeNode(4, node8, node9);
        TreeNode node5 = new TreeNode(5, node10, node11);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);

        List<Integer> list = new ArrayList<>();
        System.err.println(preOrder(node1));
        preOrder2(node1, list);
        System.err.println(list);
        list.clear();

        System.err.println(midOrder(node1));
        midOrder2(node1, list);
        System.err.println(list);
        list.clear();

        System.err.println(proOrder(node1));
        proOrder2(node1, list);
        System.err.println(list);
        list.clear();
    }
}
