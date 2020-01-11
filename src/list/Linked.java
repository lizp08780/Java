package list;

public class Linked<T> {
    private Node<T> head;            //头结点
    private int size;            //链表元素个数

    public Linked() {
        this.head = null;
        this.size = 0;
    }

    //获取链表元素的个数
    public int getSize() {
        return this.size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return this.size == 0;
    }

    //链表头部添加元素
    public void addFirst(T t) {
        this.head = new Node(t, head);
        this.size++;
    }

    //向链表尾部插入元素
    public void addLast(T t) {
        this.add(t, this.size);
    }

    //向链表中间插入元素
    public void add(T t, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }
        if (index == 0) {
            this.addFirst(t);
        }
        Node preNode = this.head;
        //找到要插入节点的前一个节点
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.getNext();
        }
        Node node = new Node(t);
        //要插入的节点的下一个节点指向preNode节点的下一个节点
        node.setNext(preNode.getNext());
        //preNode的下一个节点指向要插入节点node
        preNode.setNext(node);
        this.size++;
    }

    //删除链表元素
    public void remove(T t) {
        if (head == null) {
            System.out.println("无元素可删除");
            return;
        }
        //要删除的元素与头结点的元素相同
        while (head != null && head.getData().equals(t)) {
            head = head.getNext();
            this.size--;
        }
        /**
         * 上面已经对头节点判别是否要进行删除
         * 所以要对头结点的下一个结点进行判别
         */
        Node cur = this.head;
        while (cur.getNext() != null) {
            if (cur.getNext().getData().equals(t)) {
                this.size--;
                cur.setNext(cur.getNext().getNext());
            } else {
                cur = cur.getNext();
            }
        }
    }

    //删除链表第一个元素
    public T removeFirst() {
        if (this.head == null) {
            System.out.println("无元素可删除");
            return null;
        }
        Node<T> delNode = this.head;
        this.head = this.head.getNext();
        delNode.setNext(null);
        this.size--;
        return delNode.getData();
    }

    //删除链表的最后一个元素
    public T removeLast() {
        if (this.head == null) {
            System.out.println("无元素可删除");
            return null;
        }
        //只有一个元素
        if (this.size == 1) {
            return this.removeFirst();
        }
        Node<T> cur = this.head;    //记录当前结点
        Node<T> pre = this.head;    //记录要删除结点的前一个结点
        while (cur.getNext() != null) {
            pre = cur;
            cur = cur.getNext();
        }
        pre.setNext(cur.getNext());
        this.size--;
        return cur.getData();
    }

    //链表中是否包含某个元素
    public boolean contains(T t) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.getData().equals(t)) {
                return true;
            } else {
                cur = cur.getNext();
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.head.toString();
    }

    public static <T> Node<T> reverse(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> result = new Node(null);
        result.setNext(node);
        Node<T> p = node;
        Node<T> pNext = p.getNext();
        while (pNext != null) {
            p.setNext(pNext.getNext());
            pNext.setNext(result.getNext());
            result.setNext(pNext);
            pNext = p.getNext();
        }
        return result.getNext();
    }

    public static void main(String[] args) {
        Linked<Integer> linked = new Linked();
        for (int i = 0; i < 10; i++) {
            linked.addFirst(i);
            System.out.println(linked);
        }
        System.err.println("=====");
        System.err.println("==反转==" + Linked.reverse(linked.head));
/*        linked.addLast(33);
        linked.addFirst(33);
        linked.add(33, 5);
        System.out.println(linked);
        linked.remove(33);
        System.out.println(linked);
        System.out.println("删除第一个元素：" + linked.removeFirst());
        System.out.println(linked);
        System.out.println("删除最后一个元素：" + linked.removeLast());
        System.out.println(linked);*/
    }
}
