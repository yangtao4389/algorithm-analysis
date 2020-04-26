package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorker(int num);
    void removeWorker(int num);
    int getJobSize();

}
