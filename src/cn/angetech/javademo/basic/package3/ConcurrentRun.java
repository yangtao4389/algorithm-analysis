package cn.angetech.javademo.basic.package3;

import java.util.concurrent.CountDownLatch;

public class ConcurrentRun {
    /*
     * 模拟并发
     * 并发数：threadNum
     * 执行任务：task
     *
     * */
    void concurrentRun(int threadNum,final Runnable task){
        // CountDownLatch是用于阻塞线程 你可以向CountDownLatch对象设置一个初始的数字作为计数值，
        // 任何调用这个对象上的await()方法都会阻塞，直到这个计数器的计数值被其他的线程减为0为止。
        // start 实现同时开始
        // end 实现全部结束
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch end = new CountDownLatch(threadNum);

        // 将全部线程start，但并未执行run
        // end 统计每个线程结束，直到全部结束
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        start.await();// todo 在执行任务前等待start统一开始并发 主函数调用start.countDonw();
                        task.run();
                    } catch (InterruptedException e) {

                    } finally {
                        end.countDown();
                    }
                }
            };
            thread.start();
        }
        // 并发执行任务
        System.out.println("start"); // 在打印台中，必须为最早出现
        start.countDown();

        // 等待所有进程执行完
        try {
            end.await();
        } catch (InterruptedException e) {

        }
        System.out.println("end");
    }

}
