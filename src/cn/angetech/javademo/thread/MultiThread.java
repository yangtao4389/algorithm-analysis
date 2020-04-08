package cn.angetech.javademo.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {
    public static void main(String[] args) {
        // 获取java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor 和 synchronize 信息 仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }
        /*
        *
        * [6]Monitor Ctrl-Break
[5]Attach Listener 添加事件
[4]Signal Dispatcher  分发处理给JVM 信号的线程
[3]Finalizer  调用对象 finalize方法的线程
[2]Reference Handler  清除reference 线程
[1]main  程序入口
        * */


    }
}
