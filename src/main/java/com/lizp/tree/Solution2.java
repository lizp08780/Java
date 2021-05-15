package com.lizp.tree;

import java.util.ArrayList;

/**
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 */
public class Solution2 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> re = new ArrayList<>();
        if (root == null) {
            return re;
        }
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        int count = 0;
        while (!nodeList.isEmpty()) {
            int s = nodeList.size();
            ArrayList<Integer> dataList = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                int index = count % 2 == 0 ? i : s - 1 - i;
                TreeNode t = nodeList.get(i);
                dataList.add(nodeList.get(index).val);
                if (t.left != null) nodeList.add(t.left);
                if (t.right != null) nodeList.add(t.right);
            }
            for (int i = 0; i < s; i++) {
                nodeList.remove(0);
            }
            re.add(dataList);
            count++;
        }
        return re;
    }
}
