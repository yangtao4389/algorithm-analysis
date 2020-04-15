package cn.angetech.javademo.thread;

import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;


/*
* ThreadLocal 案例
* 保证给所有线程 分配的数据都是一样 并且让线程在自己内部的内存中 去处理这个值
*
* */
public class ThreadLocalExample implements Runnable{
    // formatter 在线程中对其进行改变，并不影响其他线程依旧是 当前初始化值
    private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyyMMdd HHmm"));


    @Override
    public void run() {
        System.out.println("Thread name="+Thread.currentThread().getName() + "default Formatter = "+ formatter.get().toPattern() );
        try{
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());
        System.out.println("Thread name="+Thread.currentThread().getName() + "formatter = "+formatter.get().toPattern());
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(threadLocalExample, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }
}
