package cn.angetech.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 桶排序
* 用桶直接顺序存储，再取出就好
* */
public class BucketSort {
    private static int indexFor(int a, int min, int step){
        return (a-min)/step;
    }
    public static void bucketSort(int[] arr){
        int min = arr[0],max = arr[0];
        for (int a:arr){
            if (max<a){
                max = a;
            }
            if(min > a){
                min = a;
            }
        }

        int bucketNum = max/10 - min/10 +1;
        // create bucket
        List<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<bucketNum;i++){
            bucketList.add(new ArrayList<Integer>());
        }
        // push into bucket
        for (int i=0;i<arr.length;i++){
            int index = indexFor(arr[i],min,10);
            bucketList.get(index).add(arr[i]);
        }
        ArrayList<Integer> bucket = null;
        int index = 0;
        for (int i=0;i<bucketNum;i++){
            bucket = bucketList.get(i);
            insertSort(bucket);
            for (int k:bucket){
                arr[index++] = k; // todo index++ 先赋值  后++
            }
        }

    }
    private static void insertSort(List<Integer> bucket){
        for (int i=1;i<bucket.size();i++){
            int temp = bucket.get(i);
            int j = i-1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,4,1,3,4,6,7,8,9,10,2,3,1};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
