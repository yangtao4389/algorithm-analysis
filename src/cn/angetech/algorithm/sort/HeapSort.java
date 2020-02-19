package cn.angetech.algorithm.sort;


/**
 * @Description:堆排序
 * @author: yt
 * @create: 2020/2/19
**/
public class HeapSort {

    public static int[] heap = new int[]{1,2,3,4,5,6,1,2,3};
    // 建立堆
    public static void createHeap(int root,int index) {
        int i,j;
        int temp;
        int finish;
        j = 2*root;
        temp = heap[root];
        finish = 0;
        while (j<index && finish ==0) {
            if(j<index) {
                if(heap[j] < heap[j+1]){
                    j++;
                }
                if(temp>= heap[j]){
                    finish = 1;
                }else {
                    heap[j/2] = heap[j];
                    j = 2*j;
                }
            }
            heap[j/2] = temp;
        }
    }

    // 堆排序
    public static void heapSort(int index) {
        int i,j,temp;
        for(i=(index/2);i>=1;i--){
            createHeap(i,index);
        }
        for(i=(index-1);i>=1;i--){
            temp = heap[i+1];
            heap[i+1] = heap[1];
            heap[1] = temp;
            createHeap(1,i);
            for (j=1;j<=index;j++) {
                System.out.print(""+heap[j]+"");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        heapSort(heap.length-1);
    }

}
