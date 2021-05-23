package com.lizp.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution4 {
    /**
     * 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
     *
     * @param root
     * @return
     */
    public boolean[] judgeIt(TreeNode root) {
        boolean[] ans = new boolean[]{true, true};
        if (root == null) {
            return ans;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                nums.add(cur.val);
                cur = cur.right;
            }
        }
        //升序，说明是搜索二叉树
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                ans[0] = false;
                break;
            }
        }
        return ans;
    }
}
