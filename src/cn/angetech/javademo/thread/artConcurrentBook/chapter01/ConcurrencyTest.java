package cn.angetech.javademo.thread.artConcurrentBook.chapter01;

import java.util.concurrent.LinkedTransferQueue;

public class ConcurrencyTest {
    private static final long count = 100000000;


    /*
    * 循环次数   并发ms   串行ms
    *  10         10       0
    *  100        2        0
    *  1000       0        0
    *  10000      8        0
    *  100000     2        3
    *  1000000    5        4
    *  10000000   7        9
    *  100000000  38       93
    * */
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }

    /*
    * 多线程
    * */
    private static void concurrency() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                for (long i = 0; i < count; i++) {
                    a += 5;
                }
            }
        });
        thread.start();

        int b = 0;
        for (long i=0;i<count;i++){
            b --;
        }

        long time = System.currentTimeMillis() - start;
        thread.join();
        System.out.println("concurrency :"+ time + "ms,b="+b);

    }


    /*
    * 线性
    * */
    private static void serial(){
        long start = System.currentTimeMillis();
        int a = 0;
        for (long i=0;i<count;i++){
            a += 5;

        }
        int b =0;
        for (long i=0;i<count;i++){
            b--;
        }

        long time = System.currentTimeMillis() - start;

        System.out.println("serial:"+time+"ms,b="+b+",a="+a);



    }



}
