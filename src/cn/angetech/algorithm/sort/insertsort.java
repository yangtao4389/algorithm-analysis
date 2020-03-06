package cn.angetech.algorithm.sort;

import cn.angetech.datastructure.heap.IntegerComparable;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * 直接插入排序
 *
 * （1）令i从1 递增到 n-1 重复步骤（2）-（4）
 * （2） 将元素si 保存到临时变量中
 * （3）确定使得条件 sj >= si 成立的最小j
 * （4） 将子序列{sj,...,si-1} 后移一个位置到 {sj+1...,si}
 * （5）将保存在临时变量中的原来的si复制到sj
 * （6）打印排序结果
 * */
public class insertsort {
    public static int[] Data = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3};

    public static void main(String[] args) {
//        int i;  // 循环变量
//        int index = 0; // 数组下标变量
//
//        System.out.println("input the values you want to sort():");
//        InputStreamReader is = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(is);
//        String  st;
//        insertSort(2);
//        insertSort(7);


        // 为空，为1判断
        if (Data.length == 0 || Data.length == 1) {
            System.out.println(Data);
        }
        // 1,3
        int currentValue, i, j;
        for (i = 1; i < Data.length; i++) {
            currentValue = Data[i];
            j = i - 1;
            while (j >= 0 && currentValue < Data[j]) {
                Data[j + 1] = Data[j];
                j--;
            }
            Data[j + 1] = currentValue;
        }
        for (i = 0; i < Data.length; i++) {
            System.out.print(" " + Data[i] + " ");
        }
        System.out.println();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(3);
//        list.add(5);
//        insertionSort(list);
        // 这里是自定义可以比较的类
        IntegerComparable[] integerComparables = new IntegerComparable[3];
        integerComparables[0] = new IntegerComparable(1);
        integerComparables[1] = new IntegerComparable(3);
        integerComparables[2] = new IntegerComparable(2);

        insertionSort(integerComparables);

        for (int k =0;k<integerComparables.length;k++){
            System.out.println(integerComparables[k].num);
        }
    }


    // 更全面的写法
    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a) {
        int j;
//        int p;
        AnyType tmp;
        for (int p = 1; p < a.length; p++){
            tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }

    }





}
