package cn.angetech.datastructure.array;

/*
* 假设二维数组 以 行为主序存储， 将它转换为按列为主序的存储算法。
* */
public class arrayzhuan {
    public static void main(String[] args) {
        int[][] data = {{9,7,6,6},{3,4,5,6},{1,2,3,4},{1,1,1,1}};
        // 存储以行 为主序的 二维数组
        int[] rowdata = new int[20];
        int[] coldata = new int[20];

        int i,j;
        System.out.println("输出二维数组");
        for (i=0;i<5;i++) {
            for(j=0;j<4;j++) {
                rowdata[i*4 +j] = data[i][j];
                System.out.println("");
                System.out.println("the rowmajor matrix:");
                for(i=0;i<20;i++) {
                    System.out.println(" "+rowdata[i]+" ");
                    System.out.println("");
                }
                for (i=0;i<5;i++) {
                    for(j=0;j<4;j++) {
                        coldata[j*5+i] = data[i][j];
                        System.out.println("");
                    }
                    for(i=0;i<20;i++) {
                        System.out.println(" " + coldata[i] + " ");
                        System.out.println("");
                    }
                }
            }
        }

    }

}
