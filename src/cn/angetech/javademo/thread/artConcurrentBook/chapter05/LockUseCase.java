package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.concurrent.locks.Lock;
// reentrant  再进入
import java.util.concurrent.locks.ReentrantLock;

public class LockUseCase {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
