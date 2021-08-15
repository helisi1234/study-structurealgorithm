package structure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Array {

    private int[] data;
    private int size;
//  有参构造，接收容量
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }
//  有参构造，接收静态数组
    public Array(int[] array) {
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }
        size = array.length;
    }
//  无参构造
    public Array() {
        data = new int[10];
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
    public void addLast(int e) {
        add(size, e);
    }
//  头添加
    public void addFirst(int e) {
        add(0, e);
    }
//  向特定位置添加元素
    public void add(int index, int e) {
        if(size == data.length) {
            //todo 扩容
        }
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        for (int i = size-1;i >= index;i --) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
//  查询数组元素
    public int get(int index) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        return data[index];
    }
//  修改数组元素
    public void set(int index, int e) {
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("参数错误");
        }
        data[index] = e;
    }
//  查找元素
    public boolean contains(int e) {
        for (int dataE : data) {
            if(dataE == e) {
                return true;
            }
        }
        return false;
    }
//  查找元素位置
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }
//  查找特定元素全部位置
    public List<Integer> findAll(int e) {
        List<Integer> resultList = new ArrayList();
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                resultList.add(e);
            }
        }
        if(resultList.isEmpty()) {
            System.out.println("不存在这个元素");
        }
        return resultList;
    }
//  删除全部特定元素
    public void removeAll(int e) {
        List<Integer> resultList = findAll(e);
        if(resultList.isEmpty()) {
            System.out.println("不存在这个元素");
        }
        Iterator<Integer> resIter = resultList.iterator();
        while(resIter.hasNext()) {
            remove(resIter.next());
        }
    }
//  删除特定位置元素
    public int remove(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("参数错误");
        }
        int ret = data[index];
        for (int i = index+1;i < size;i ++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }
//  删头
    public int removeFirst() {
        return remove(0);
    }
//  删尾
    public int removeLast() {
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
}
