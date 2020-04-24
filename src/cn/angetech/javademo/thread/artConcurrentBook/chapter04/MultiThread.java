package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/*
* 使用jmx 查看一个普通的java程序 包含哪些线程
*
* */
public class MultiThread {
    public static void main(String[] args) {
        // 获取java线程管理 mxbean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        // 获取所有线程信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        /*
6Monitor Ctrl-Break
5Attach Listener
4Signal Dispatcher
3Finalizer
2Reference Handler  //
1main
        *
        *
        * */
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.print(threadInfo.getThreadId());
            System.out.print(threadInfo.getThreadName());
            System.out.println();
        }


    }

}
