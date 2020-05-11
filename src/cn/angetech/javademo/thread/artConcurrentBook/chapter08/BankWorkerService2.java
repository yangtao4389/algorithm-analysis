package cn.angetech.javademo.thread.artConcurrentBook.chapter08;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

public class BankWorkerService2 implements Runnable {
    private CyclicBarrier c = new CyclicBarrier(4, this);
    //保存每个sheet计算出的银流结果
    private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count() {
        for (int i = 0; i < 4; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("first execute:" + Thread.currentThread().getName());
                    sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                    try {
                        c.await(); // 把执行任务交给屏障
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end execute:" + Thread.currentThread().getName());
                }
            }).start();
        }
    }


    @Override
    public void run() {
        System.out.println("轮到屏障执行");
        System.out.println(sheetBankWaterCount);
        System.out.println("执行结束");
    }


    public static void main(String[] args) {
        // todo 主程序可以停止
        new BankWorkerService2().count();
    }


}
