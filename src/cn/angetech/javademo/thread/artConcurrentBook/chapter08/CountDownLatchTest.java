package cn.angetech.javademo.thread.artConcurrentBook.chapter08;

import java.util.concurrent.CountDownLatch;

/*
* latch  占用
*
* */
public class CountDownLatchTest {
    // CountDownLatch的构造函数接收一个int类型的参数作为计数器，如果你想等待N个点完
    // 成，这里就传入N。
    static CountDownLatch c =  new CountDownLatch(2);


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                // 当我们调用CountDownLatch的countDown方法时，N就会减1，CountDownLatch的await方法
                //会阻塞当前线程，直到N变成零。
                c.countDown();
                System.out.println(2);
            }
        }).start();
        c.await();
        System.out.println(3);
    }

}
