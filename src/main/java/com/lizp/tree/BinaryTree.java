package com.lizp.tree;

import java.util.*;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public Integer getHeight() {
        return getHeight(root);
    }

    public Integer getSize() {
        return getSize(root);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void midOrder() {
        midOrder(root);
    }

    public void proOrder() {
        proOrder(root);
    }

    public void nonRecOrder() {
        nonRecOrder(root);
    }

    //得到树的深度
    public static Integer getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = getHeight(node.getLeftChildTree());
            int right = getHeight(node.getRightChildTree());
            //左子树 右子树最深的，再加上父节点本身深度1
            return left > right ? left + 1 : right + 1;
        }
    }

    //得到节点数量
    public static Integer getSize(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftSize = getSize(node.getLeftChildTree());
            int rightSize = getSize(node.getRightChildTree());
            return leftSize + rightSize + 1;
        }
    }

    //前序遍历,迭代
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.println("preOrder" + node.getData());
            preOrder(node.getLeftChildTree());
            preOrder(node.getRightChildTree());
        }
    }

    //中序遍历,迭代
    public static void midOrder(Node node) {
        if (node == null) {
            return;
        } else {
            midOrder(node.getLeftChildTree());
            System.out.println("midOrder" + node.getData());
            midOrder(node.getRightChildTree());
        }
    }

    //后序遍历,迭代
    public static void proOrder(Node node) {
        if (node == null) {
            return;
        } else {
            proOrder(node.getLeftChildTree());
            proOrder(node.getRightChildTree());
            System.out.println("proOrder" + node.getData());
        }
    }

    //前序遍历，非迭代
    public static void nonRecOrder(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println("nonRecOrder:" + pop.getData());
            if (pop.getRightChildTree() != null)//不要把空节点push栈
                stack.push(pop.getRightChildTree());
            if (pop.getLeftChildTree() != null)
                stack.push(pop.getLeftChildTree());
        }
    }

    public void creatBinaryTree(LinkedList<String> data) {
        creatBinaryTree(0, data);
    }

    //用前序遍历反向生成二叉树
    private Node creatBinaryTree(int index, LinkedList<String> data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String d = data.pop();
        if (d == null || d.equals("#")) {
            return null;
        }
        Node node = new Node<>(d);
        if (index == 0) {
            root = node;
        }
        node.setLeftChildTree(creatBinaryTree(++index, data));
        node.setRightChildTree(creatBinaryTree(++index, data));
        return node;
    }


    public Node<Integer> put(Integer data) {
        if (data == null) {
            return null;
        }
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        Node<Integer> node = root;
        Node<Integer> parent = null;
        while (node != null) {
            parent = node;
            if (node.getData() > data) {
                node = node.getLeftChildTree();
            } else if (node.getData() < data) {
                node = node.getRightChildTree();
            } else {
                return node;
            }
        }
        node = new Node<>(data);
        node.setParent(parent);
        if (parent.getData() > data) {
            parent.setLeftChildTree(node);
        } else {
            parent.setRightChildTree(node);
        }
        return node;
    }

    public Node getNodeByData(Integer data) {
        if (data == null || root == null) {
            return null;
        }
        Node<Integer> node = root;
        while (node != null) {
            if (node.getData().equals(data)) {
                return node;
            } else if (node.getData() > data) {
                node = node.getLeftChildTree();
            } else {
                node = node.getRightChildTree();
            }
        }
        return null;
    }

    public Integer delete(Integer data) {
        Node node = getNodeByData(data);
        if (node == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        Node parent = node.getParent();
        //要删除节点的父节点 关系中断
        if (parent.getLeftChildTree() == node) {
            parent.setLeftChildTree(null);
        } else {
            parent.setRightChildTree(null);
        }
        getDataPreOrder(list, node);
        list.remove(data);
        //把数据重新放一次
        for (Integer i : list) {
            put(i);
        }
        return data;
    }

    //找到某节点下的所有数据放在list，旧节点属性置空
    private void getDataPreOrder(List list, Node node) {
        if (node == null) {
            return;
        }
        node.setParent(null);
        list.add(node.getData());
        getDataPreOrder(list, node.getLeftChildTree());
        node.setLeftChildTree(null);
        getDataPreOrder(list, node.getRightChildTree());
        node.setRightChildTree(null);
        node.setData(null);
    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     *
     * @param root
     * @return
     */
    public static List<Integer> printFromTopToBottom(Node<Integer> root) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        List<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                Node<Integer> t = queue.poll();
                if (t == null) {
                    continue;
                }
                ret.add(t.getData());
                queue.add(t.getLeftChildTree());
                queue.add(t.getRightChildTree());
            }
        }
        return ret;
    }
}
