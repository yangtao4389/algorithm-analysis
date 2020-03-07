package cn.angetech.algorithm.sort;


import java.util.Arrays;

/**
 * @Description:堆排序
 * @author: yt
 * @create: 2020/2/19
**/
public class HeapSort {
    private int[] arr;
    public HeapSort(int[] arr){
        this.arr = arr;
    }

    // 程序主入口
    public void sort(){
        // 1. 将数组堆化，根节点要求它以下值 为最大
        int len = arr.length -1;
        int beginIndex = (arr.length >> 1) -1; //todo 右移一位，相当于/2  根据二叉树的规律，父节点从/2 都为父节点  但下标从0开始，所以从6开始到0，
        // 根据所有的父节点来满足堆的性质
        for (int i = beginIndex; i>= 0;i--){
            maxHeapify(i,len);
        }
        System.out.println(Arrays.toString(arr));

        // 2. 对堆化数据排序  每次移出最顶处的根节点A[0], 与尾部节点位置调换，同时遍历长度-1
        // 然后重新整理被换到根节点的末尾元素，使其符合堆的特性
        for (int i=len;i>0;i--){
            swap(0,i);
            maxHeapify(0,i-1);
        }
    }

    private void swap(int i,int j){
        int tmp = arr[i];
        arr[i]= arr[j];
        arr[j] = tmp;
    }


    /*
    * 满足堆的性质
    * 传入的index  为 父节点
    * 左右节点的值为 index*2 +1    +2
    * 根据左右节点来看大小，然后再根据左右节点与父亲的大小做对比，然后进行元素的交换，下标不动
    *
    * 判断完后
    * 再根据当初左右节点位置中 数字 比较大的 那个为  父节点  继续判断是否满足堆的性质，形成递归调用
    * */
    private void maxHeapify(int index, int len){
        int li = (index << 1)+1;
        int ri = li +1;
        int cMax = li;
        if(li>len) return;
        if (ri<=len && arr[ri]>arr[li]){
            cMax = ri;
        }
        if (arr[cMax] >arr[index]){
            swap(cMax, index);
            maxHeapify(cMax,len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,5,3,4,1,3,4,6,7,8,9,10,2,3,1};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));

        System.out.println(3>>1);
    }

}
