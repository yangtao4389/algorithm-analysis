package cn.angetech.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;  // 重写compare来实现   compareTo是java.lang 自带属性

public class CompareToSort {
    public static void main(String[] args) {
        compareTo();
    }

    public static void compareTo(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(0);
        arrayList.add(-1);
        System.out.println("原始数组：");
        System.out.println(arrayList);

        // 按自然排序的升序排序
        Collections.sort(arrayList);
        System.out.println("Collections.sort(arrayList)：");
        System.out.println(arrayList);


        // 定制排序
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // compareTo 是本身自带的属性
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后");
        System.out.println(arrayList);

    }
}
