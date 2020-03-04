package cn.angetech.datastructure.heap;


import org.omg.CORBA.Any;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
* 完全二叉树的 数组实现
* 一个堆结构 由一个 Comparable对象的 数组 和一个代表当前堆的大小的整数组成
* */
public class BinaryHeap <AnyType extends Comparable<? super AnyType>> {


    public static void main(String[] args) throws Exception{


//        int[] a= {1,2,3};
//        System.out.println(a[0]);
//        for (Integer integer:a){
//           System.out.println(integer);
//        }
//        List list = new ArrayList();
        IntegerComparable[] integerComparables = new IntegerComparable[3];
        integerComparables[0] = new IntegerComparable(1);
        integerComparables[1] = new IntegerComparable(2);
        integerComparables[2] = new IntegerComparable(3);

        BinaryHeap binaryHeap = new BinaryHeap(integerComparables);
        binaryHeap.insert(new IntegerComparable(-1));
        IntegerComparable min = (IntegerComparable)binaryHeap.deleteMin();
        IntegerComparable min2 = (IntegerComparable)binaryHeap.deleteMin();

        System.out.println(min2.num);

        // 标准库的优先队列
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(integerComparables);
        System.out.println(priorityQueue.remove());

    }

    public void test(AnyType[] items){
        System.out.println(items);
    }

    public BinaryHeap(){
        currentSize = DEFAULT_CAPACITY;
        buildHeap();
    }
    public BinaryHeap(int capacity){
        currentSize = capacity;
        buildHeap();
    }
    public BinaryHeap(AnyType[] items){
        currentSize = items.length;
        array = (AnyType[]) new Comparable[(currentSize+2)*11/10];
        int i = 1;  //todo 这里的出发点，让返回最小值为 array[1]
        for (AnyType item:items)
            array[i++] = item;
        buildHeap();
    }


    /*
    * 通过二叉树的上虑，将 一个元素 插入到空穴。如果没法插入，则上冒。
    * */
    public void insert(AnyType x){
        if(currentSize == array.length -1)
            enlargeArray(array.length*2 +1); // 扩容

        int hole = ++currentSize;
        for (;hole>1 && x.compareTo(array[hole/2])<0;hole/=2){
            array[hole] = array[hole/2];
        }
        array[hole] = x;
    }


    /*
    *   我们通过将 树的 根  作为最小元
    *   所以找到该元的 为时间常数O(1)
    *
    * */
    public AnyType findMin(){
        if( isEmpty())
            throw new NullPointerException();
//            return null;
        return array[1];

    }
    public AnyType deleteMin(){
        if (isEmpty())
            throw new BufferUnderflowException();
        AnyType minItem = findMin();
        array[1] = array[currentSize --];
        perolateDown(1);
        return minItem;
    }
    private static final int DEFAULT_CAPACITY = 10;
    private int currentSize;
    private AnyType[] array;


    /*
    * percolate  过滤
    * 主要将数据
    *
    * */
    private void perolateDown(int hole){
        int child;
        AnyType tmp = array[hole];

        for (;hole*2 <= currentSize; hole=child){
            child = hole*2;
            if (child!= currentSize && array[child+1].compareTo(array[child])<0){
                child ++;
            }
            if (array[child].compareTo(tmp)<0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }
    private void buildHeap(){
        for (int i= currentSize/2;i>0;i--){
            perolateDown(i);
        }
    }
    private void enlargeArray(int newSize){

    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

}
