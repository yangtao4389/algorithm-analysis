package cn.angetech.javademo.thread.avo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadCount {
    public volatile static int count = 0;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 2000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    count++;
                }
            });
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
