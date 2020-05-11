package cn.angetech.javademo.thread.artConcurrentBook.chapter08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Exchanger（交换者）是一个用于线程间协作的工具类。
 * Exchanger用于进行线程间的数据交换。
 * 它提供一个同步点，在这个同步点，两个线程可以交换彼此的数据。
 * 这两个线程通过exchange方法交换数据，
 * 如果第一个线程先执行exchange()方法，它会一直等待第二个线程也执行exchange方法，
 * 当两个线程都到达同步点时，这两个线程就可以交换数据，将本线程生产出来的数据传递给对方。
 * 下面来看一下Exchanger的应用场景。
 * Exchanger可以用于遗传算法，
 * 遗传算法里需要选出两个人作为交配对象，这时候会交换两人的数据，并使用交叉规则得出2个交配结果。
 * Exchanger也可以用于校对工作，比如我们需要将纸制银行流水通过人工的方式录入成电子银行流水，
 * 为了避免错误，采用AB岗两人进行录入，录入到Excel之后，系统需要加载这两个Excel，并对两个Excel数据进行校对，看看是否录入一致，
 * 代码如代码清单8-8所示
 * */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        // exgr 只限定两个线程，所以这下面的3个线程去使用该方法，会造成各种组合结果出现
        /*
        * A与C数据是否一致：false
        A:银行流水b
        A与B数据是否一致：false
        A:银行流水c
        B:银行流水b
        *
        * */

        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                String A = "银行流水a";
                try {
                    exgr.exchange(A);
                } catch (InterruptedException e) {

                }

            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                String B = "银行流水b";
                try {
                    String A = exgr.exchange(B);
                    System.out.println("A与B数据是否一致："+A.equals(B));
                    System.out.println("A:"+A);
                    System.out.println("B:"+B);
                } catch (InterruptedException e) {

                }

            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {

                String C = "银行流水c";
                try {
                    String A = exgr.exchange(C);
                    System.out.println("A与C数据是否一致："+A.equals(C));
                    System.out.println("A:"+A);
                   // System.out.println("B:"+B);
                } catch (InterruptedException e) {

                }

            }
        });
        threadPool.shutdown();
    }

}
