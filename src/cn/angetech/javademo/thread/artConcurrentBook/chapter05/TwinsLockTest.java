package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import cn.angetech.javademo.thread.artConcurrentBook.chapter04.SleepUtils;

import java.util.concurrent.locks.Lock;

public class TwinsLockTest {
    public static void main(String[] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread{
            @Override
            public void run() {
                // 对锁的获取与释放
                for (;;){
                    lock.lock();
                    try{
                        SleepUtils.second(1);
                        System.out.println(Thread.currentThread().getName());
                        SleepUtils.second(1);
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }


        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
//            worker.setDaemon(true);
            worker.start();
        }

//        for (int i = 0; i < 10; i++) {
//            SleepUtils.second(1);
//            System.out.println();
//        }

    }



}
