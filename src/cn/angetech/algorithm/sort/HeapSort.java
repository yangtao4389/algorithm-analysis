package cn.angetech.algorithm.sort;


/**
 * @Description:堆排序
 * @author: yt
 * @create: 2020/2/19
**/
public class HeapSort {
    private static int leftChild( int i){
        return 2*i +1;
    }

    private static <AnyType extends Comparable<? super AnyType>> void percDown(AnyType[] a, int i,int n){
        int child;
        AnyType tmp ;
        for (tmp=a[i]; leftChild(i)<n;i=child){
            child = leftChild(i);
            if (child != n-1 && a[child].compareTo(a[child +1])<0){
                child ++;
            }
            if (tmp.compareTo(a[child])<0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;

    }





    public static <AnyType extends Comparable<? super AnyType>> void heapsort(AnyType[] a){
        for (int i=a.length/2;i>=0;i--){ // build heap
            percDown(a,i,a.length);
        }
        for (int i=a.length-1;i>0;i--){
//            swapReferences(a,0,i);        // delete max
            percDown(a,0,i);
        }
    }


    /**********************************************************************************/
    //改成int[]

    /*
    * 删除 或者 构建 heap
    * */
    private static  void percDown2(int[] a, int i,int n){
        int child;
        Integer tmp ;
        for (tmp=a[i]; leftChild(i)<n;i=child){
            child = leftChild(i);
            if (child != n-1 && a[child]-a[child +1]<0){
                child ++;
            }
            if (tmp.compareTo(a[child])<0){
                a[i] = a[child];
            }else {
                break;
            }
        }
        a[i] = tmp;

    }

    public static void heapsort2(int[] a){
        for (int i=a.length/2;i>=0;i--){ // build heap
            percDown2(a,i,a.length);
        }
//        for (int i=a.length-1;i>0;i--){
////            swapReferences(a,0,i);        // delete max
//            percDown2(a,0,i);
//        }
    }


    public static void main(String[] args) {
        int[] heap = new int[]{1,2,3,4,5,6,1,2,3};
        Integer[] heap2 = new Integer[]{1,2,3,4,5,6,1,2,3};
        System.out.print( heap.equals(heap2));
        heapsort2(heap);
        for (Integer integer:heap){
            System.out.print(integer+" ");
        }

        heapsort(heap2);


        int a =100;
        int b = 100;
        System.out.println(a == b);  // true
        Integer c = 100;
        Integer d = 100;
        System.out.println(c == d);  // true
        System.out.println(c.equals(d));
        System.out.println(d == b);  // true


        Integer e = new Integer(100);
        Integer f = new Integer(100);
        System.out.println(e == f);  // false
        System.out.println(e);


        //todo  两个非new生成的Integer对象进行比较，如果两个变量的值在区间[-128,127]之间，比较结果为true；否则，结果为false。
        Integer g = 128;
        Integer h = 128;
        System.out.println(g == h);  // false

        int k = 1280000000;
        int l = 1280000000;
        System.out.println(k == l); // true


        // todo int与Integer 比较，只要值相等，就相等。。所以以后只要注意Integer，两个比较居然是不等，而是一个对象的地址。
        Integer m = 1280000000;
        System.out.println(k == m);  // true
        Integer n = new Integer(1280000000);
        System.out.println(k == n);// true

        String o = "asd";
        String p = "asd";
        System.out.println(o==p); // true

        // 关于int与Integer的问题的处理
        // https://blog.csdn.net/tongsiw/article/details/89851213?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
    }

}
