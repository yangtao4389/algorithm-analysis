package cn.angetech.javademo.thread.avo;

import cn.angetech.javademo.thread.artConcurrentBook.chapter04.ThreadPool;

public class VolatileApp {
    // volatile关键字会强制的保证线程的可见性
    private static boolean isOver = false;
    private static int num = 0;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isOver) {
                   // Thread.yield();   // Thread.yield()也会保证可见性？
                }
                System.out.println(num);
            }
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 50;
        isOver = true;

    }

}
