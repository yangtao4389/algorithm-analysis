package cn.angetech.javademo.thread.artConcurrentBook.chapter08;

/*
* CyclicBarrier可以用于多线程计算数据，最后合并计算结果的场景。
* 例如，
* 用一个Excel保存了用户所有银行流水，
* 每个Sheet保存一个账户近一年的每笔银行流水，
* 现在需要统计用户的日均银行流水，
* 先用多线程处理每个sheet里的银行流水，都执行完之后，
* 得到每个sheet的日均银行流水，
* 最后，再用barrierAction用这些线程的计算结果，计算出整个Excel的日均银行流水
*
* */

import java.util.Map;
import java.util.concurrent.*;

public class BankWorkerService implements Runnable{
    // 创建4个屏障，处理完之后执行当前类的run方法
    private CyclicBarrier c = new CyclicBarrier(4,this);
    // 假设只有4个sheet，所以只启动4个线程
    private Executor executor = Executors.newFixedThreadPool(4);
    //保存每个sheet计算出的银流结果
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    // 计算当前sheet的银流数据，计算代码省略
                    sheetBankWaterCount.put(Thread.currentThread().getName(),1);
                    // 银流计算完成，插入一个屏障
                    try{
                        System.out.println("first execute:"+Thread.currentThread().getName());
                        c.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end execute:"+Thread.currentThread().getName());
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        // 汇总每个sheet计算出的结果
       for (Map.Entry<String,Integer> sheet:sheetBankWaterCount.entrySet()){
           result += sheet.getValue();
       }
       // 将结果输出
        sheetBankWaterCount.put("result",result);
        System.out.println(result);

    }

    public static void main(String[] args) {
        // todo  为何主程序不会停止呢。。
        BankWorkerService bankWorkerService = new BankWorkerService();
        bankWorkerService.count();
    }
}
