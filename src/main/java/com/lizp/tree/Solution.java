package com.lizp.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 */
public class Solution {
    public static List<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (root == null) {
            return arrayList;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int s = list.size();
            ArrayList<Integer> nList = new ArrayList<>();
            for (int i = 0; i < s; i++) {
                TreeNode t = list.get(0);
                nList.add(t.val);
                if (t.left != null) {
                    list.add(t.left);
                }
                if (t.right != null) {
                    list.add(t.right);
                }
                list.remove(0);
            }
            arrayList.add(nList);
        }
        return arrayList;
    }
}
