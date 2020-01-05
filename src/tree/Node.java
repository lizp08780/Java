package tree;

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
}
