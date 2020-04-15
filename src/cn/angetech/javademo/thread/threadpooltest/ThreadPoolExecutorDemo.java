package cn.angetech.javademo.thread.threadpooltest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
*
* 编写测试程序，我们这里以阿里巴巴推荐的使用 ThreadPoolExecutor 构造函数自定义参数的方式来创建线程池。
* */
public class ThreadPoolExecutorDemo {

    /*
    *
    * int corePoolSize,
      int maximumPoolSize,
      long keepAliveTime,
      TimeUnit unit,
      BlockingQueue<Runnable> workQueue
    * */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 10; i++) {
            MyRunnable myRunnable = new MyRunnable(" " + i);
            threadPoolExecutor.execute(myRunnable);
        }

        // 终止线程池
        threadPoolExecutor.shutdown();
        while (!threadPoolExecutor.isTerminated()){

        }
        System.out.println("Finished all threads");


    }

}
