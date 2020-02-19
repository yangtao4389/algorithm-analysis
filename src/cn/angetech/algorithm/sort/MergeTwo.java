package cn.angetech.algorithm.sort;

/**
 * @Description:归并排序
 * @author: yt
 * @create: 2020/2/19
**/
public class MergeTwo {
    public static int[] Data = new int[]{1,2,3,4,5,6,1,2,3};
    public static int[] Output = new int[]{1,2,3,4,5,6,1,2,3};
    // 两两归并
    public static void mergeTwo(int left,int middle,int n) {
        int i,j,k,t;
        i = left;
        k = left;
        j = middle +1;

        while (i<=middle && j<=n) {
            if (Data[i] <= Data[j]) {
                Output[k] = Data[i];
                i++;
            }else {
                Output[k] = Data[j];
                j++;
            }
            k = k+1;
        }

        if(i>middle) {
            for (t=j;t<=n;t++) {
                Output[k+t-j] = Data[t];
            }
        }else {
            for (t=i;t<=middle;t++){
                Output[k+t-j] = Data[t];
            }
        }
    }

    public static void mergeAll(int n,int datalength) {
        int i,t;
        i=0;
        while (i<=(n-2*datalength +1)) {
            mergeTwo(i,i+datalength-1,i+2*datalength-1);
            i = i+2*datalength;
        }
        if(i+datalength-1<n){
            mergeTwo(i,i+datalength-1,n);
        } else {
            for(t=i;t<n;t++) {
                Output[t] = Data[t];
            }
            // 将output中的值复制到data
            for(t=0;t<=n;t++){
                Data[t] = Output[t];
            }
            for (i=0;i<=n;i++) {
                System.out.print(""+Output[i]+"");
            }
        }


    }
}
