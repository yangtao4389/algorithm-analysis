package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.lang.management.ThreadInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "waitThread");
        waitThread.start();

        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }



    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {  // 加锁 拥有lock的Monitor
                while (flag) {  //  当条件不满足时，继续wait  同时释放lock的锁
                    try {
                        System.out.println(Thread.currentThread() + " flag is true,wa@" + new SimpleDateFormat("HH:mm:SS").format(new Date()));
                        lock.wait();  // 这里会释放锁资源 加入 WaitQueue
                    } catch (InterruptedException e) {
                    }
                }
                // 条件满足完成工作
                System.out.println(Thread.currentThread() + " flag is false,running@" + new SimpleDateFormat("HH:mm:SS").format(new Date()));
            }
        }
    }


    static class Notify implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                // 获取lock的锁 进行通知 通知时 不会释放lock的锁
                //  直到当前线程释放了 lock后 waitThread才能从wait方法中返回
                System.out.println(Thread.currentThread() + " hold lock. notify@" + new SimpleDateFormat("HH:mm:SS").format(new Date()));
                lock.notifyAll();  // 使Wait 加入同步队列
                flag = false;
                // SleepUtils.second(5);

            }
            // 再次加锁
            synchronized (lock){
                System.out.println(Thread.currentThread() + " hold lock. again.sleep@" + new SimpleDateFormat("HH:mm:SS").format(new Date()));
                SleepUtils.second(5);
            }


        }
    }

}
