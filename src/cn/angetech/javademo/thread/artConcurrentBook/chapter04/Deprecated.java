package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/*
*
* 如果把它播放音乐比作一个线程的运作，那么对音乐播放
做出的暂停、恢复和停止操作对应在线程Thread的API就是suspend()、resume()和stop()。

但下述的所有方法 都已经废弃 不建议使用
* */
public class Deprecated {
    public static void main(String[] args) throws InterruptedException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:SS");
        Thread printThread = new Thread(new Runner(), "PrintThread");
        printThread.setDaemon(true);
        printThread.start();

        TimeUnit.SECONDS.sleep(3);
        // 将printThread 进行暂停，输入内容工作停止
        printThread.suspend();
        System.out.println("main suspend printThread at "+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        // 恢复
        printThread.resume();
        System.out.println("main resume printThread at "+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);
        // 停止
        printThread.stop();
        System.out.println("main stop printThread at "+ format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

    }
    static class Runner implements Runnable{
        @Override
        public void run() {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm:SS");
            while (true){
                System.out.println(Thread.currentThread().getName()+"Run at"+format.format(new Date()));
                SleepUtils.second(1);
            }

        }
    }
}
