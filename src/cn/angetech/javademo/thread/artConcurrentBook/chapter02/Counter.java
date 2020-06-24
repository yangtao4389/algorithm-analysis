package cn.angetech.javademo.thread.artConcurrentBook.chapter02;

import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 利用 CAS  compare and swap  自旋锁 来实现累计计数
*
* */
public class Counter {
    private AtomicInteger atomicInteger =  new AtomicInteger(0);

    private int i = 0;

    public static void main(String[] args) {
        final Counter cas = new Counter();
        ArrayList<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();

        // 创建100个线程 放入 ts
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int k = 0; k < 1000; k++) {
                        cas.count();
//                        cas.safeCount();
                    }
                }
            });
            ts.add(t);
        }

        /*
        *
        * */
        for (Thread t:ts){
            t.start();
        }

        // 等待线程执行完成
        for (Thread t:ts){
            try {
                t.join();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }

        }
       /*
       不安全
       * cas.i:99984
cas.atomicInteger.get():0
System.currentTimeMillis()-start:35ms
       *
       * */

       /*
       安全
cas.i:0
cas.atomicInteger.get():100000
System.currentTimeMillis()-start:14ms
       *
       * */


        System.out.println("cas.i:"+cas.i);
        System.out.println("cas.atomicInteger.get():"+cas.atomicInteger.get());
        System.out.println("System.currentTimeMillis()-start:"+ (System.currentTimeMillis()-start)+"ms");

    }


    /*
    * 利用CAS实现的线程 安全 计数器
    * */
    private void safeCount(){
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }

    private void count(){
        i++;
    }



}
