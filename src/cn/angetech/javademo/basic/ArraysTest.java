package cn.angetech.javademo.basic;

import java.util.*;

public class ArraysTest {
    public static void main(String[] args) throws Exception{
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原始arrayList："+arrayList);
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        System.out.println("原始HashSet:"+hashSet);

        Map scores = new HashMap();
        scores.put("语文",80);
        scores.put("java",90);
        System.out.println("原始Map:"+scores);

        char[] e = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        char[] f = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        System.out.println(e== f);
        System.out.println(Arrays.equals(e,f));

        int[] g = { 1, 2, 3, 3, 3, 3, 6, 6, 6 };
        Arrays.fill(g,3);
        for (int i:g){
            System.out.print(i);  // 全部填充 333333
        }
        System.out.println();

        int[] k = {1,2,3,4,5,6};
        int result =  Arrays.binarySearch(k, 3);
        System.out.println(result);



    }
}
