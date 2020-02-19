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
        int[] Data = new int[]{1,2,3,4,5,6,1,2,3};

        int i,j,k; // 循环变量
        int temp;
        boolean change;
        int datalength;
        int pointer;
        int index = Data.length-1;
        datalength = (int) index/2;  // 1/2 0/2  都为0
        while (datalength != 0) {
            for(j=datalength;j<index;j++) {
                change = false;
                temp = Data[j];
                pointer = j-datalength;
                while (temp<Data[pointer] && pointer>=0 && pointer<=index) {
                    Data[pointer+datalength] = Data[pointer];
                    pointer = pointer-datalength;
                    change = true;
                    if(pointer<0 || pointer>=index) {
                        break;
                    }
                }
                Data[pointer+datalength] = temp;

                if(change) {
                    for(k=0;k<index;k++) {
                        System.out.print(" " + Data[k] + " ");
                    }
                }
                datalength = datalength/2;
            }
        }



    }

}
