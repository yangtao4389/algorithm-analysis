package cn.angetech.datastructure.linklist;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.omg.CORBA.Any;

import java.util.Iterator;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private AnyType[] theItems;

    public MyArrayList(){
        clear();
    }

    public void clear(){
        theSize = 0;
        ensureCapacity( DEFAULT_CAPACITY );
    }

    public int size(){
        return theSize;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public void trimToSize(){
        ensureCapacity(size());
    }

    public AnyType get(int idx){
        if(idx<0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public AnyType set(int idx,AnyType newVal){
        if(idx<0 || idx >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity){
        if(newCapacity < theSize)
            return;
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i=0;i<size();i++)
            theItems[i] = old[i];
    }

    public boolean add(AnyType x){
        add( size(),x);
        return true;
    }

    public void add(int idx, AnyType x){
        if(theItems.length == size())
            ensureCapacity(size()*2 + 1);
        for(int i=theSize;i>idx;i--){
            theItems[i] = theItems[i-1];
        }
        theItems[idx] = x;
        theSize ++;
    }

    public AnyType remove( int idx){
        AnyType removedItem = theItems[idx];
        for (int i=idx;i<size()-1;i++){
            theItems[i] = theItems[i+1];
        }
        theSize--;
        return removedItem;
    }


    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator(this);
    }




    /*
    * 迭代器一号版本 不能使用
    * */
//    private class ArrayListIterator implements Iterator<AnyType>{
//        private int current = 0;
//        @Override
//        public boolean hasNext() {
//            return current<size();
//        }
//
//        @Override
//        public AnyType next() {
//            if(!hasNext()){
//                throw new java.util.NoSuchElementException();
//            }
//            // todo ,这里是非法的，因为theItems 不是ArrayListIterator的一部分，而是MyArrayList的一部分
//            return theItems[current ++];
//        }
//
//        @Override
//        public void remove() {
//            MyArrayList.this.remove(--current);
//        }
//    }


    /*
     * 迭代器二号版本 几乎可以使用
     * */

//    class ArrayListIterator implements Iterator<AnyType>{
//        private int current = 0;
//        private MyArrayList<AnyType> theList;
//
//        public ArrayListIterator(MyArrayList<AnyType> list){
//            theList = list;
//        }
//
//
//        @Override
//        public boolean hasNext() {
//            return current<theList.size();
//        }
//
//        @Override
//        public AnyType next() {
//            if(!hasNext()){
//                throw new java.util.NoSuchElementException();
//            }
//
//            return theList.theItems[current ++];
//        }
//
//        @Override
//        public void remove() {
//            MyArrayList.this.remove(--current);
//        }
//    }

    /*
     * 迭代器三号版本
     * 用static 来表示它是嵌套的  若无static，将得到一个内部类，有时好，有时不好。
     * */

    private static class ArrayListIterator<AnyType> implements Iterator<AnyType>{
        private int current = 0;
        private MyArrayList<AnyType> theList;

        public ArrayListIterator(MyArrayList<AnyType> list){
            theList = list;
        }


        @Override
        public boolean hasNext() {
            return current<theList.size();
        }

        @Override
        public AnyType next() {
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }

            return theList.theItems[current ++];
        }

        @Override
        public void remove() {
            theList.remove(--current);
        }
    }


    /*
     * 迭代器四号版本
     *
     * */

//    private class ArrayListIterator<AnyType> implements Iterator<AnyType>{
//        private int current = 0;
////        private MyArrayList<AnyType> theList;
//
////        public ArrayListIterator(MyArrayList<AnyType> list){
////            theList = list;
////        }
//
//
//        @Override
//        public boolean hasNext() {
//            return current<size();
//        }
//
//        @Override
//        public AnyType next() {
//            if(!hasNext()){
//                throw new java.util.NoSuchElementException();
//            }
//            return theItems[current++];
//
//        }
//
//        @Override
//        public void remove() {
//            MyArrayList.this.remove(--current);
//        }
//    }
}
