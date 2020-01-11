package tree;

import java.util.Arrays;

public class Node<T> {
    private Integer index;
    private Node<T> leftChildTree;
    private Node<T> rightChildTree;
    private Node<T> parent;  //父节点
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Node<T> getLeftChildTree() {
        return leftChildTree;
    }

    public void setLeftChildTree(Node<T> leftChildTree) {
        this.leftChildTree = leftChildTree;
    }

    public Node<T> getRightChildTree() {
        return rightChildTree;
    }

    public void setRightChildTree(Node<T> rightChildTree) {
        this.rightChildTree = rightChildTree;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //根据前序遍历与中序遍历构造二叉树
    public static <T> Node<T> buildTree(T[] preorder, T[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        //1.根据前序，找到根的值，并且创建根节点
        T rootValue = preorder[0];
        Node root = new Node(rootValue);

        //2.在中序中找到根的值所在的下标
        int leftSize = find(inorder, rootValue);

        //3.切出左子树的前序和中序
        T[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        T[] leftInorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.leftChildTree = buildTree(leftPreorder, leftInorder);

        //4.切出右子树的前序和中序
        T[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        T[] rightInorder = Arrays.copyOfRange(inorder, leftSize + 1, preorder.length);
        root.rightChildTree = buildTree(rightPreorder, rightInorder);

        return root;
    }

    private static <T> int find(T[] array, T v) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
