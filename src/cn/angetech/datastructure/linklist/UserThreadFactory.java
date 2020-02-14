package cn.angetech.datastructure.linklist;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 创建线程 或 线程池时  请指定有意义的线程名称， 方便出错时回调
* */
public class UserThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    // 定义线程组名称，在jstack问题排查时，非常有帮助
    UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "From UserThreadFactory's " + whatFeatureOfGroup + "-Worker-";
    }

    private void task1() {
        System.out.println("thread");
    }


    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(r);
        System.out.println(thread.getName());
        return thread;
    }
}
