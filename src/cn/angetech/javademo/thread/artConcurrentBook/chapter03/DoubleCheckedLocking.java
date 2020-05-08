package cn.angetech.javademo.thread.artConcurrentBook.chapter03;
/*
* 利用重复验证
* 获取instance
* 但是还是有问题
* 问题在于：
*
* */
public class DoubleCheckedLocking {
    static class Instance{}
    private volatile static Instance instance;  // 如果加上volatile  就不会造成instance还未初始化完全了
    public static Instance getInstance(){
        if (instance == null){
            synchronized (DoubleCheckedLocking.class){  // todo 防止多线程初始化
                if (instance == null){
                    instance = new Instance();
                }
            }

        }
        return instance;
    }



}
