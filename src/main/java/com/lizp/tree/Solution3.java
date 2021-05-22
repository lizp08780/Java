package com.lizp.tree;

import java.util.Stack;

/**
 * 反转
 */
public class Solution3 {
    /**
     * 递归方式
     *
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//先将根节点压入堆栈
        while (stack.size() > 0) {
            TreeNode temp = stack.pop();//弹出栈顶元素

            //交换左右子树
            TreeNode tempLeft = temp.left;
            temp.left = temp.right;
            temp.right = tempLeft;

            //左子树不为空，将左子树入栈
            if (temp.left != null) {
                stack.push(temp.left);
            }
            //右子树不为空，将右子树入栈
            if (temp.right != null) {
                stack.push(temp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1, node3, node4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0, node1, node2);
        invertTree2(node0);

        //System.err.println(Solution.levelOrder(node0));
        // System.err.println(Solution.levelOrder(invertTree(node0)));
    }
}
