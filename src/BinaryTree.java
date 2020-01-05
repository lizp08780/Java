public class BinaryTree {

    private Node root;

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
