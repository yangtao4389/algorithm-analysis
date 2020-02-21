package cn.angetech.datastructure.linklist;

import java.util.Collection;
import java.util.Iterator;

public class CollectionAPI {

    public static void print(Collection collection) {
        for(Object item:collection) {
            System.out.println(item);
        }


    }


    /*
    * 实现Iterable 接口的集合 必须提供一个成为 iterator 的方法  该方法返回一个Iterator类型的对象
    *
    * Iterator是一个java.util包中定义的接口
    *public interface Iterator<AnyType>{
    *   boolean hasNext();
    *   AnyType next();
    *   void remove();
    * }
    *
    *
    * */
    public static void printIterator(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            Object item = iterator.next();
            System.out.println(item);
        }
    }
}
