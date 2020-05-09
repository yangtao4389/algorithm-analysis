package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* 一般都会将Condition对象作为成员变量。
* 当调用await()方法后，当前线程会释放锁并在此等待，
* 而其他线程调用Condition对象的signal()方法，通知当前线程后，
* 当前线程才从await()方法返回，并且在返回前已经获取了锁。
*
* */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal() {
        lock.lock();
        try{
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
