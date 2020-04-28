package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*
* 定义两个线程 对资源的控制
*
* TwinsLock实现了Lock接口，提供了面向使用者的接口，使用者调用lock()
方法获取锁，随后调用unlock()方法释放锁，而同一时刻只能有两个线程同时获取到锁
* */
public class TwinsLock implements Lock{
    private final Sync sync = new Sync(2);


    /*
    * TwinsLock同时包含了一个自定义同步器Sync，
    * 而该同步器面向线程访问和同步状态控制。
    * 以共享式获取同步状态为例：同步器会先计算出获取后的同步状态，然后通过CAS确保状态的正确设置，
    * 当tryAcquireShared(int reduceCount)方法返回值大于等于0时，当前线程才获取同步状态，对于上层的TwinsLock而言，则表示当前线程获得了锁
    *
    * */
    private static final class Sync extends AbstractQueuedSynchronizer{
        Sync(int count){
            if (count <= 0){
                throw new IllegalArgumentException("count must be large than zero.");
            }
            setState(count);
        }
        public int tryAcquireShared(int reduceCount){
            for (;;){  // 死循环用这个， 寄存器的指令要比 while（true）少
                int current = getState();
                int newCount = current - reduceCount;
                if (newCount<0 || compareAndSetState(current,newCount)){
                    return newCount;
                }

            }
        }

        public boolean tryReleaseShared(int returnCount){
            for (;;){
                int current = getState();
                int newCount = current + returnCount;
                if (compareAndSetState(current,newCount)){
                    return true;
                }
            }
        }
        final ConditionObject newCondition() {
            return new ConditionObject();
        }

    }
    @Override
    public void lock(){
        sync.acquireShared(1);
    }
    @Override
    public void unlock(){
        sync.releaseShared(1);
    }

    public void lockInterruptibly() throws InterruptedException{
        sync.acquireSharedInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquireShared(1) >= 0;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException{
        return sync.tryAcquireSharedNanos(1,unit.toNanos(time));
    }
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

}
