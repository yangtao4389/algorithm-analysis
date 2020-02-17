package cn.angetech.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class translateArray {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] b = new int[]{5,6,7,8};
        String[] c = {"a","b"};
        System.out.println(a.getClass().getSimpleName());
//        System.out.println(a instanceof Integer);
//        List list = new ArrayList()

        // 数组 转 List
        List list = Arrays.asList(a);
        System.out.println(a[0]);
        System.out.println(list);
//        list.add(1);

        ArrayList<Integer> arrayList = new ArrayList(Arrays.asList(a));
        System.out.println(arrayList);

        List list1 = Arrays.asList(c);
        System.out.println(c.getClass().getSimpleName());
        System.out.println(list1);

        ArrayList arrayList1 = new ArrayList(Arrays.asList(c));
        System.out.println(arrayList1);
        arrayList1.add("c");
        System.out.println(arrayList1);
    }

}
