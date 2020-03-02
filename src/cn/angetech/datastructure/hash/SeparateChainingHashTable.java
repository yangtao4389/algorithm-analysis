package cn.angetech.datastructure.hash;

import org.omg.CORBA.Any;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
* 分离链接散列表
*
* 算出hash值，
*  public static int hash(String key, int tableSize){
        int hashVal = 0;
        for (int i=0;i<key.length();i++){
            hashVal = 31*hashVal + key.charAt(i);
        }
        hashVal %= tableSize;
        return hashVal;
    }
*根据tableSize，来分配具体的存储路径。
*
* 现在解决 %= 后遇到的冲突，即两个key都需要存储在同一个位置上。
*
* */
public class SeparateChainingHashTable<AnyType> {

    /*
    * construct the hash table;
    * */
    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }
    /*
    * construct the hash table
    * param size approximate table size
    * */
    public SeparateChainingHashTable( int size){
        theLists = new LinkedList[nextPrime(size)];
        for (int i=0;i<theLists.length;i++){
            theLists[i] = new LinkedList<AnyType>();
        }
    }


    public void makeEmpty(){
        for(int i=0;i<theLists.length;i++){
            theLists[i].clear();
        }
        //theSize = 0;
    }



    /*
    * find an item in the hash table
    * return true if x is not found
    * */
    public boolean contains(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    public void insert(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if(!whichList.contains(x)){
            whichList.add(x);
            if(++currentSize > theLists.length)
                rehash();
        }
    }

    public void remove(AnyType x){
        List<AnyType> whichList = theLists[myhash(x)];
        if (whichList.contains(x)){
            whichList.remove(x);
            currentSize --;
        }
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<AnyType>[] theLists;
    private int currentSize;

    private void rehash(){
        List<AnyType>[] oldLists = theLists;
        theLists = new List[nextPrime(2*theLists.length)];
        for (int j=0;j<theLists.length;j++){
            theLists[j] = new LinkedList<AnyType>();

        }
        currentSize = 0;
        for (int i=0;i<oldLists.length;i++){
            for (AnyType item:oldLists[i]){
                insert(item);
            }
        }
    }
    private int myhash(AnyType x){
        int hashVal = x.hashCode();
        hashVal %= theLists.length;
        if (hashVal<0){
            hashVal += theLists.length;
        }
        return hashVal;
    }

    private static int nextPrime(int n){
        // todo 这里有问题
        return 1;
    }
//    private static boolean isPrime(int n){
//
//    }



}
