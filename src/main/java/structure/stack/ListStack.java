package structure.stack;

import structure.List.LinkedList;

public class ListStack<E> implements Stack<E>{

    private LinkedList<E> linkedList;

    public ListStack() {
        linkedList = new LinkedList<E>();
    }

    public void push(E e) {
        linkedList.addFirst(e);
    }

    public E pop() {
        return linkedList.removeFirst();
    }

    public E peek() {
        return linkedList.getFirst();
    }

    public int getSize() {
        return linkedList.getSize();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack top: ");
        res.append(linkedList);
        return res.toString();
    }
}
