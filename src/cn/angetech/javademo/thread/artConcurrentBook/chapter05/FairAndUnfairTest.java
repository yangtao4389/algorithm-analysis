package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {
    public static void main(String[] args) {
//        new FairAndUnfairTest().fair();
        /*
        * Lock by [0],Waiting by []
Lock by [1],Waiting by [4, 3, 2, 0]
Lock by [4],Waiting by [3, 2, 0, 1]
Lock by [3],Waiting by [2, 0, 1, 4]
Lock by [2],Waiting by [0, 1, 4, 3]
Lock by [0],Waiting by [1, 4, 3, 2]
Lock by [1],Waiting by [4, 3, 2]
Lock by [4],Waiting by [3, 2]
Lock by [3],Waiting by [2]
Lock by [2],Waiting by []
        * */

        new FairAndUnfairTest().unfair();
        /*
        * Lock by [0],Waiting by []
Lock by [0],Waiting by [1, 4]
Lock by [1],Waiting by [4, 3, 2]
Lock by [1],Waiting by [4, 3, 2]
Lock by [4],Waiting by [3, 2]
Lock by [4],Waiting by [3, 2]
Lock by [3],Waiting by [2]
Lock by [3],Waiting by [2]
Lock by [2],Waiting by []
Lock by [2],Waiting by []
        *
        * */
    }


    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    private static CountDownLatch start;

    public void fair() {
        testLock(fairLock);
    }

    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        start = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            Thread thread = new Job(lock);
            thread.setName("" + i);
            thread.start();
        }
        start.countDown();
    }


    /*
     * 自定义 重进入锁 传入false 与 true  实现公平锁
     * */
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            ArrayList<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    private static class Job extends Thread {
        private Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    System.out.println("Lock by [" + getName() + "],Waiting by " + ((ReentrantLock2) lock).getQueuedThreads());
                    Thread.sleep(3);
                }catch (InterruptedException e){}
                finally {
                    lock.unlock();
                }
            }
        }

        @Override
        public String toString() {
            return getName();
        }
    }


}
