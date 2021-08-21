package structure.Queue;

import structure.Array.Array;

public class ArrayQueue<E> implements Queue<E>{

    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array(capacity);
    }

    public ArrayQueue() {
        array = new Array();
    }

    public void enqueue(E e) {
        array.addLast(e);
    }

    public E dequeue() {
        return array.removeFirst();
    }

    public E getFront() {
        return array.getFirst();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize()-1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
