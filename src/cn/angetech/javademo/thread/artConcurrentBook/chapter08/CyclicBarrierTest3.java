package cn.angetech.javademo.thread.artConcurrentBook.chapter08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
* CountDownLatch与CyclicBarrier的不同
* CountDownLatch的计数器只能使用一次，
* 而CyclicBarrier的计数器可以使用reset()方法重置。
* 所以CyclicBarrier能处理更为复杂的业务场景。
* 例如，如果计算发生错误，可以重置计数器，并让线程重新执行一次。
* CyclicBarrier还提供其他有用的方法，
* 比如
* getNumberWaiting方法可以获得Cyclic-Barrier阻塞的线程数量。
* isBroken()方法用来了解阻塞的线程是否被中断。
* 代码清单8-5执行完之后会返回true，其中isBroken的使用代码如代码清单8-6所示。
*
* */
public class CyclicBarrierTest3 {
    static CyclicBarrier c = new CyclicBarrier(2);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程开始");
                try {
                    System.out.println("线程等待CyclicBarrier");
                    c.await();
                    System.out.println("线程等待CyclicBarrier结束");

                } catch (Exception e) {
                    System.out.println("线程等待CyclicBarrier出错");
                }
            }
        });
        thread.start();
        // 模拟打断
        thread.interrupt();
        try {
            System.out.println("thread 主线程等待");
            c.await();
        } catch (Exception e) {
            System.out.println("thread 主线程等待 出错");
            System.out.println(c.isBroken());
        }

    }

}
