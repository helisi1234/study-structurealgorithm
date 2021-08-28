package structure.List;

public class LinkedList<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;  //虚拟头节点
    int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        Node prev = dummyHead;
//        index位置前一个元素
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size-1);
    }

    public E remove(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return cur.e;
    }

//    获取第index个元素
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size-1);
    }

//    将第index个元素设置为e
    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Add Failed");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

//    查找元素
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }



    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            res.append(cur.e + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
