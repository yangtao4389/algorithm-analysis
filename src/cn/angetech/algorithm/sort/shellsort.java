package cn.angetech.algorithm.sort;

/*
 * 希尔排序
 * 先取定一个小于n的整数 d1 作为第一个增量
 * 把文件的全部记录分成 d1 个组
 * 所有距离为d1的倍数的记录放在同一组中
 * 在各组中内进行插入排序
 * 取第二个增量 d2< d1
 * 重复上述分组和排序
 * 直到 所取的增量 dt = （dt<dt-1<...<d2<d1）
 *
 * */
public class shellsort {
    public static void main(String[] args) {
        int[] Data = new int[]{1, 2, 3, 4, 5, 6, 1, 2, 3};
//        shellSortN(Data);
        shellSort2(Data);

        for (int m = 0; m < Data.length; m++) {
            System.out.print(Data[m] + " ");
        }
        System.out.println();

    }

    public static void shellSortN(int[] Data) {

        int i, j, k; // 循环变量
        int temp;
        boolean change;
        int datalength;
        int pointer;
        int index = Data.length;
        datalength = (int) index / 2;  // 1/2 0/2  都为0
        while (datalength > 0) {
            for (j = datalength; j < index; j++) {
                temp = Data[j];
                pointer = j - datalength;
                while (temp < Data[pointer] && pointer >= 0 && pointer <= index) {
                    Data[pointer + datalength] = Data[pointer];
                    pointer = pointer - datalength;
                    if (pointer < 0 || pointer >= index) {
                        break;
                    }
                }
                Data[pointer + datalength] = temp;


            }
            datalength = datalength / 2;
        }
    }


    /*
     * 第二种写法
     * */
    public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a) {
        int j;
        // 设置间隙，直到<0
        for (int gap = a.length / 2; gap > 0; gap /= 2) {  // 假设 gap = 3 a.length = 11
            for (int i = gap; i < a.length; i++) { // 从第一次的gap开始排序， i 3,11 ++
                AnyType tmp = a[i];  // a[3]
                for (j = i; j >= gap && tmp.compareTo(a[j - gap]) < 0; j -= gap) {  // j=3  a[3]-a[0]<0  j=0
                    a[j] = a[j - gap];  //
                }
                a[j] = tmp;
            }
        }
    }

    /*
     * 直接处理数组写法
     * */
    public static void shellSort2(int[] array) {
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                Integer tmp = array[i];
                for (j = i; j >= gap && tmp - array[j - gap] < 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }
    }


}
