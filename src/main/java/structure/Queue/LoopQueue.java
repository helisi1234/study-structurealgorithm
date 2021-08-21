package structure.Queue;

//循环队列优化数组队列出队o(n)的问题
public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
//        需要消耗一个空间存放tail
        data = (E[])new Object[capacity+1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public void enqueue(E e) {
        if((tail+1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return data[front];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return tail == front;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public void resize(int newcapacity) {
        E[] newData = (E[]) new Object[newcapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            res.append(data[i]);
            if((i+1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

}
