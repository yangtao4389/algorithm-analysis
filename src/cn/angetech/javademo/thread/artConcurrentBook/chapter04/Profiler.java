package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

/*
* 利用 threadLocal 实现 对执行时间的统计
* */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<>();

    protected Long initialValue(){
        return System.currentTimeMillis();
    }

    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        SECONDS.sleep(1);
        System.out.println("cost:"+Profiler.end()+"mills");
    }

}
