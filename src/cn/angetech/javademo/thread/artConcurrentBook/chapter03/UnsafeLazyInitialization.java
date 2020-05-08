package cn.angetech.javademo.thread.artConcurrentBook.chapter03;


/*
* 非安全的初始化 见SafeLazyInitialization 安全的初始化操作
* */
public class UnsafeLazyInitialization {
    private static Instance instance;
    private static Instance getInstance(){
        if (instance == null){
            instance = new Instance();

        }
        return instance;
    }

    static class Instance{}
}
