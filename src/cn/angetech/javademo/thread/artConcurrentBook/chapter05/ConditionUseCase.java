package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
