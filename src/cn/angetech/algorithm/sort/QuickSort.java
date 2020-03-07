package cn.angetech.algorithm.sort;

import java.util.Arrays;

/*
* 快速排序
* */
public class QuickSort {
    public static void qSort(int[] arr,int head, int tail){
        if (head>=tail || arr == null || arr.length<=1){
            return;
        }

        // 选取一个中间值  然后<的放左边，>的放右边
        // 怎么放？
        // 通过比较左右两边的数  然后进行交换

        int i = head,j=tail,pivot = arr[(head+tail)/2];
        while (i<=j){
            while (arr[i]<pivot){
                ++i;  //todo 先运算在赋值
            }
            while (arr[j]>pivot){
                --j;
            }

            if (i<j){
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            }else if (j == i){
                ++i;
            }

        }
        System.out.println(Arrays.toString(arr));
        System.out.println(i);
        qSort(arr,head,j);
        qSort(arr,i,tail);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,3};
        qSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
