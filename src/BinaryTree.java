import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树
 */
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
        if (node == null)
            return 0;
        else {
            int left = getHeight(node.getLeftChildTree());
            int right = getHeight(node.getRightChildTree());
            //左子树 右子树最深的，再加上父节点本身深度1
            return left > right ? left + 1 : right + 1;
        }
    }

    //得到节点数量
    public static Integer getSize(Node node) {
        if (node == null)
            return 0;
        else {
            int leftSize = getSize(node.getLeftChildTree());
            int rightSize = getSize(node.getRightChildTree());
            return leftSize + rightSize + 1;
        }
    }

    //前序遍历,迭代
    public static void preOrder(Node node) {
        if (node == null)
            return;
        else {
            System.out.println("preOrder" + node.getData());
            preOrder(node.getLeftChildTree());
            preOrder(node.getRightChildTree());
        }
    }

    //中序遍历,迭代
    public static void midOrder(Node node) {
        if (node == null)
            return;
        else {
            midOrder(node.getLeftChildTree());
            System.out.println("midOrder" + node.getData());
            midOrder(node.getRightChildTree());
        }
    }

    //后序遍历,迭代
    public static void proOrder(Node node) {
        if (node == null)
            return;
        else {
            proOrder(node.getLeftChildTree());
            proOrder(node.getRightChildTree());
            System.out.println("proOrder" + node.getData());
        }
    }

    //前序遍历，非迭代
    public static void nonRecOrder(Node node) {
        if (node == null)
            return;
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
        Node node = new Node<>(d);
        if (d == null) {
            return null;
        }
        if (index == 0) {
            root = node;
        }
        if (d.equals("#")) {
            return null;
        }
        node.leftChildTree = creatBinaryTree(++index, data);
        node.rightChildTree = creatBinaryTree(++index, data);
        return node;
    }

    static class Node<T> {
        private Integer index;
        private Node leftChildTree;
        private Node rightChildTree;
        private T data;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Node getLeftChildTree() {
            return leftChildTree;
        }

        public void setLeftChildTree(Node leftChildTree) {
            this.leftChildTree = leftChildTree;
        }

        public Node getRightChildTree() {
            return rightChildTree;
        }

        public void setRightChildTree(Node rightChildTree) {
            this.rightChildTree = rightChildTree;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node(T data) {
            this.data = data;
            this.leftChildTree = null;
            this.rightChildTree = null;
        }
    }
}
