package cn.angetech.javademo.thread.artConcurrentBook.chapter04;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    // 线程池最大限制数
    private static final int MAX_WORKER_NUMBERS = 10;
    // 线程池默认的数量
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    // 线程池最小的数量
    private static final int MIN_WORKER_NUMBERS = 1;

    // 工作列表
    private final LinkedList<Job> jobs =  new LinkedList<Job>();  // 生成者
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());  // 消费者

    // 工作这线程的数量
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    // 线程编号生成
    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {

    }
    public DefaultThreadPool(int num) {
        // 自定义num  使其位于 最大thread 与 最小 thread 之间
        workerNum = num>MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWorkers(num);

    }

    @Override
    public void execute(Job job) {
        if (job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notifyAll();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }

    }

    @Override
    public void addWorker(int num) {
        synchronized (jobs){
            if (num + this.workerNum >MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }

    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num>=this.workerNum){
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count<num){
                workers.get(count).shutdown();
                count++;
            }
            this.workerNum -= count;

        }

    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    /*
    * 初始化worker 即 线程池处理 job  --->>>>  job.run
    * */
    private void initializeWorkers(int num){
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();

        }
    }





    class Worker implements Runnable{
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try{
                            jobs.wait();
                        }catch (InterruptedException ex){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null){
                    try{
                        job.run();
                    }catch (Exception ex){}
                }

            }
        }

        public void shutdown(){running = false;}
    }



}
