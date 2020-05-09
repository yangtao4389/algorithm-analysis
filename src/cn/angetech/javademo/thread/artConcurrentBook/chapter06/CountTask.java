package cn.angetech.javademo.thread.artConcurrentBook.chapter06;
/*
* 使用Fork/Join框架，需求是：计算1+2+3+4的结果。
* */

import cn.angetech.javademo.thread.artConcurrentBook.chapter04.Profiler;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
* ForkJoinTask：我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。
* 它提供在任务中执行fork()和join()操作的机制。
* 通常情况下，我们不需要直接继承ForkJoinTask类，只需要继承它的子类，Fork/Join框架提供了以下两个子类。
·RecursiveAction：用于没有返回结果的任务。
·RecursiveTask：用于有返回结果的任务。
*
*
* */
public class CountTask extends RecursiveTask<Integer> {
    private int start;
    private int end;
    // 阈(yu)值
    private static final int THRESHOLD = 2;
    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start)<=THRESHOLD;
        if(canCompute){
            for (int i = start; i <= end ; i++) {
                sum += i;
            }
        }else {
            // 分裂成两个子任务
            int middle = (start+end)/2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle+1, end);

            // 执行子任务
            leftTask.fork();
            rightTask.fork();

            // 等待子任务执行完，并得到其结果
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // 合并子任务
            sum = leftResult+rightResult;

        }

        return sum;

    }


    public static void main(String[] args) {
        Profiler.begin();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 生成一个计算任务，负责计算 1+2+3+4
        CountTask task = new CountTask(1, 100000000);
        // 执行一个任务
        ForkJoinTask<Integer> result = forkJoinPool.submit(task);
        try{
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("forkJoinPool cost:"+Profiler.end()+"mills");
        Profiler.begin();
        int sum = 0;
        for (int i = 0; i <= 100000000; i++) {
            sum += i;

        }
        System.out.println(sum);
        System.out.println("for cost:"+Profiler.end()+"mills");

        /*
        * 结果：
        * 987459712
        forkJoinPool cost:1866mills
        987459712
        for cost:33mills
        对于计算密集型的，如果用多线程去执行，跑的速度比用单线程确实慢很多
        *
        * */

    }
}
