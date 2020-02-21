package cn.angetech.datastructure.linklist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
* 用于对比 ArrayList和 LinkedList
* */
public class ListTest2 {

    public static void main(String[] args) {
        makeList1(new ArrayList(),100);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        // removeEvensVer2(linkedList);// 报错
        removeEvensVer3(linkedList);
        System.out.println(linkedList);

        for(int i=0;i<1000000;i++){
            arrayList.add(i);
            linkedList.add(i);
        }
//        System.out.println(arrayList);
//        removeEvensVer3(arrayList);
        removeEvensVer3(linkedList);

    }

    /*
    * 直接追加 都是 O(N)
    * */
    public static void makeList1(List<Integer> list, int N) {
        list.clear();
        for (int i=0;i<N;i++){
            list.add(i);
        }
    }

    /*
    * 对前端 加入
    * LinkedList 运行时间是 O(N)
    * ArrayList 为 O(N^2)
    *
    * */
    public static void makeList2(List<Integer> list, int N) {
        list.clear();
        for (int i=0;i<N;i++) {
            list.add(0,i);
        }

    }


    /*
    * 计算List中的数的和
     * LinkedList 运行时间是 O(N^2)
     * ArrayList 为 O(N)
    * */
    public static void sum(List<Integer> list, int N) {
        int total = 0;
        for (int i=0;i<N;i++) {
            total += list.get(i);
        }
    }


    /*
    * 对搜索而言，ArrayList  LinkedList  都是低效 的
    * 对Collection  的 contains  和 remove 两个方法的调用均花费 线性时间
    *
    * */


    /*
    * 删除 列表中的 偶数，
    * LinkedList get昂贵
    * ArrayList 操作昂贵
    * */
    public static void removerEvensVer1(List<Integer> lst) {
        int i = 0;
        while (i<lst.size()) {
            if(lst.get(i) % 2 == 0){
                lst.remove(i);
            }else {
                i++;
            }
        }
    }

    /*
    * 使用迭代器 解决上面的问题
    *  但有问题 ConcurrentModificationException
    * */
    public static void removeEvensVer2(List<Integer> lst) {
        for (Integer x:lst) {
            if (x % 2 == 0) {
                lst.remove(x);
            }
        }
    }

    /*
    * 对上面方法修正
    * LinkedList  花费为 线性时间
    * ArrayList 由于remove 昂贵的操作， 还是O(N^2)
    *
    * */
    public static void removeEvensVer3(List<Integer> lst) {
        Iterator<Integer> itr = lst.iterator();
        while (itr.hasNext())
            if (itr.next() %2 == 0)
                itr.remove();
    }


    /*
    * ListIterator 扩展了List的Iteretor的功能
    * */


}
