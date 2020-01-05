import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
/*        BinaryTree.Node nodeB = new BinaryTree.Node("B");
        BinaryTree.Node nodeC = new BinaryTree.Node("C");
        BinaryTree.Node nodeD = new BinaryTree.Node("D");
        BinaryTree.Node nodeE = new BinaryTree.Node("E");
        BinaryTree.Node nodeF = new BinaryTree.Node("F");
        nodeB.setLeftChildTree(nodeD);
        nodeB.setRightChildTree(nodeE);
        nodeC.setRightChildTree(nodeF);
        BinaryTree.Node root = new BinaryTree.Node("A");
        root.setLeftChildTree(nodeB);
        root.setRightChildTree(nodeC);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.preOrder();
        binaryTree.midOrder();
        binaryTree.proOrder();
        System.err.println(binaryTree.getHeight());
        System.err.println(binaryTree.getSize());
        binaryTree.nonRecOrder();*/

        LinkedList l = new LinkedList();
        String[] data = new String[]{"A", "B", "D", "#", "#", "#", "C", "E", "#", "F"};
        for (String d : data) {
            l.offer(d);
        }
        BinaryTree tree = new BinaryTree();
        tree.creatBinaryTree(l);
        tree.preOrder();
    }
}
