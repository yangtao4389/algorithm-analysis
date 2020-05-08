package cn.angetech.javademo.thread.artConcurrentBook.chapter03;
/*
* 线程安全的lazy 初始化
* */
public class SafeLazyInitialization {
    static class Instance{}
    private static Instance instance;
    //todo 这样能保证线程安全，但是getInstance被经常调用的话，性能无法让人满意
    // todo 所以有了 双重检查锁定 见 DoubleCheckedLocking
    public synchronized static Instance getInstance(){
        if (instance == null){
            instance = new Instance();
        }
        return instance;
    }

}
