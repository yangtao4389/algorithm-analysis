package cn.angetech.algorithm.randomized_algorithm;


import java.util.ArrayList;

public class MyRandom2 {
    private static final int A = 48271;
    private static final int M = 2147483647;
    private static final int Q = M/A;
    private static final int R = M%A;
    private int state;

    public MyRandom2(){
        // 如果同一时段多次new  那么就会出现 state多次一致 导致最后的 randomInt也一样。所以使用的时候，先new，再random
        state = (int)System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public int randomInt(){
        int tmpState = A*(state % Q) - R * (state/ Q);

        if (tmpState >= 0){
            state = tmpState;
        }else {
            state = tmpState + M;
        }
        return state;
    }
    public double random0_1(){
        return (double)randomInt()/M;
    }

    public static void main(String[] args) {
        int a ;
        double b;
        ArrayList<Integer> arrayList = new ArrayList<>();
        MyRandom2 my = new MyRandom2();
        for (int i =0;i<10;i++){
            a = my.randomInt();
            b = my.random0_1();

            arrayList.add(i);
            System.out.println(a);
            System.out.println(b);
        }
        System.out.println(arrayList);

    }


}
