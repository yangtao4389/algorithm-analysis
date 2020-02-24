package cn.angetech.datastructure.linklist;

import org.omg.CORBA.Any;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/*
*
*
*
* */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;  // 自从构造以来 对 链表所做改变的次数  add 与 remove 调用 将 更新 modCount
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;


    /*
    *
    * 私有的嵌套类，
    *
    * */
    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;
        public Node(AnyType d,Node<AnyType> p, Node<AnyType> n){
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList(){
        clear();
    }

    public void clear(){
        beginMarker = new Node<AnyType>(null,null,null);
        endMarker =  new Node<AnyType>(null,beginMarker,null);
        beginMarker.next = endMarker;
        theSize = 0;
        modCount ++;
    }

    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean add(AnyType x){
        add(size(),x);return true;
    }
    public void add(int idx, AnyType x){
        addBefore(getNode(idx),x);
    }
    public AnyType get(int idx){
        return getNode(idx).data;
    }

    public AnyType set(int idx,AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }

    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    private void addBefore(Node<AnyType> p,AnyType x){
        Node<AnyType> newNode = new Node<>(x,p.prev,p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize ++;
        modCount ++;

    }

    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize --;
        modCount++;
        return p.data;
    }

    private Node<AnyType> getNode(int idx){
        Node<AnyType> p;
        if(idx<0 || idx>size()){
            throw new IndexOutOfBoundsException();
        }

        if(idx<size()/2){
            p = beginMarker.next;
            for (int i =0;i<idx;i++){
                p = p.next;
            }
        }else {
            p = endMarker;
            for (int i = size();i>idx;i++){
                p = p.prev;
            }
        }
        return p;

    }

    @Override
    public Iterator<AnyType> iterator() {
        return new LinkedListIterator();
    }


    /*
    *
    * 该类抽象了位置的概念，是一个私有类，并实现接口 Iterator。
    *
    *
    *
    *
    *
    * */
    private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        // 当一个迭代器被建立时，他将存储集合的modCount，每次对一个迭代器方法的调用都将用该链表内的当前modCount检测
        // 在迭代器内部存储的modCount ， 不匹配时 抛出异常。
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current!= endMarker;
        }

        @Override
        public AnyType next() {
            if(modCount != expectedModCount){
                throw  new ConcurrentModificationException();

            }
            if(!hasNext()){
                throw new NoSuchElementException();
            }

            AnyType nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;

        }

        @Override
        public void remove() {
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();
            MyLinkedList.this.remove(current.prev);
            okToRemove = false;
            expectedModCount ++;
        }
    }


}
