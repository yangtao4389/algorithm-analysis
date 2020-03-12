package cn.angetech.algorithm.randomized_algorithm;

/*
*
*找一个在0- （2^31-1）== 2147483647 的素数 来实现随机数
*
* 该方法被我直接用 Long state 来实现  本质上是不需要的。
* */
public class MyRandom {
    private static final int A = 48271;
    private static final int M = 2147483647;
    private int state;
    public MyRandom(){
        state = (int) System.currentTimeMillis() % Integer.MAX_VALUE;
    }

    public  int randomIntWRONG(){
        return state = (A*state) % M;
    }

    public double random0_1(){
        return (double)randomIntWRONG()/M;
    }

    public static void main(String[] args) {
        for (int i=0;i<1000;i++){
            int nu = new MyRandom().randomIntWRONG();
            System.out.println(nu);
        }

    }
}
