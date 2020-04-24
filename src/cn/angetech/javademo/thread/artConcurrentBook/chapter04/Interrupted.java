package cn.angetech.javademo.thread.artConcurrentBook.chapter04;
/*
* 测试中断
*
* */


import java.util.concurrent.TimeUnit;

public class Interrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread sleepRunner = new Thread(new SleepRunner(), "SleepRunner");
        sleepRunner.setDaemon(true);

        Thread busyRunner = new Thread(new BusyRunner(), "BusyRunner");
        busyRunner.setDaemon(true);
        sleepRunner.start();
        busyRunner.start();

        // 休眠5秒 让sleepRunner  busyRunner 充分运行
        TimeUnit.SECONDS.sleep(5);
        sleepRunner.interrupt();
        busyRunner.interrupt();
        System.out.println("sleepRunner interrupt "+sleepRunner.isInterrupted());
        System.out.println("busyRunner interrupt "+busyRunner.isInterrupted());
        SleepUtils.second(2);
        System.out.println("sleepRunner interrupt "+sleepRunner.isInterrupted());
        System.out.println("busyRunner interrupt "+busyRunner.isInterrupted());


    }


    // 一直睡
    static class SleepRunner implements Runnable{
        @Override
        public void run() {
            while (true){
                SleepUtils.second(10);
            }
        }
    }
    // 一直忙
    static class BusyRunner implements Runnable{
        @Override
        public void run() {
            while (true){}
        }
    }


}
