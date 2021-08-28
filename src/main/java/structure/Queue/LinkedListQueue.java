package structure.Queue;

public class LinkedListQueue<E> implements Queue<E>{

    class Node {
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

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(E e) {
        if(tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue");
        }
        Node cur = head;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        cur.next = null;
        size --;
        return cur.e;
    }

    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue");
        }
        return head.e;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue front: ");
        Node cur = head;
        while(cur != null) {
            res.append(cur.e + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
