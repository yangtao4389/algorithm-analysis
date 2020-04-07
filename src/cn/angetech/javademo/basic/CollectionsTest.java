package cn.angetech.javademo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {
        collectionsTest();
    }


    public static void collectionsTest(){
        int[] a = {1,2,3,4,5};
        System.out.println(Arrays.toString(a));
//        List<int[]> ints = Arrays.asList(a);
//        System.out.println(ints.toString());
//        int i1 = Collections.binarySearch(a, 3);


        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(arrayList);
        int i = Collections.binarySearch(arrayList, 3);
    }
}
