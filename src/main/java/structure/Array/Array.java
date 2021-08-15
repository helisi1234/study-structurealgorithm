package structure.Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Array<E> {

    private E[] data;
    private int size;
//  有参构造，接收容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }
//  有参构造，接收静态数组
    public Array(E[] array) {
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        size = array.length;
    }
//  无参构造
    public Array() {
        data = (E[]) new Object[10];
        size = 0;
    }
//  获取数组容量
    public int getCapacity() {
        return data.length;
    }
//  获取数组元素个数
    public int getSize() {
        return size;
    }
//  判空
    public boolean isEmpty() {
        return size == 0;
    }
//  尾添加
    public void addLast(E e) {
        add(size, e);
    }
//  头添加
    public void addFirst(E e) {
        add(0, e);
    }
//  向特定位置添加元素
    public void add(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        if(size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size-1;i >= index;i --) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
//  查询数组元素
    public E get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        return data[index];
    }
//  修改数组元素
    public void set(int index, E e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        data[index] = e;
    }
//  查找元素
    public boolean contains(E e) {
        for (E dataE : data) {
            if(dataE.equals(e)) {
                return true;
            }
        }
        return false;
    }
//  查找元素位置
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
//  查找特定元素全部位置
    public List<Integer> findAll(int e) {
        List<Integer> resultList = new ArrayList();
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e)) {
                resultList.add(i);
            }
        }
        if(resultList.isEmpty()) {
            System.out.println("不存在这个元素");
        }
        return resultList;
    }
//  删除特定位置元素
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("参数错误");
        }
        if(size == data.length/2) {
            resize(data.length/2);
        }
        E ret = data[index];
        for (int i = index+1;i < size;i ++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        return ret;
    }
//  删头
    public E removeFirst() {
        return remove(0);
    }
//  删尾
    public E removeLast() {
        return remove(size-1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array: size=%d, capacity=%d", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size-1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize(int newcapacity) {
        E[] newData = (E[])new Object[newcapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
