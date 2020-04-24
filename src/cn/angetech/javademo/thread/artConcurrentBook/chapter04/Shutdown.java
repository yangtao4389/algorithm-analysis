package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.util.concurrent.TimeUnit;

/*
* 安全地终止线程
* */
public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one, "CountThread");
        countThread.start();

        // 睡眠1 秒 main线程对CountThread进行中断，使得CountThread能感知中断而结束
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt(); // 这种中断来不及线程处理

        Runner two = new Runner();
        countThread = new Thread(two, "CountTwoThread");
        countThread.start();

        TimeUnit.SECONDS.sleep(1);
        two.cancel();  // 这种更优雅的线程中断方式

    }



    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()){
                i++;
            }
            System.out.println("count i = "+ i);
        }

        public void cancel(){
            on = false;
        }
    }

}
