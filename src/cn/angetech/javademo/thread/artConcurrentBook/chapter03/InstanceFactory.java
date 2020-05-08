package cn.angetech.javademo.thread.artConcurrentBook.chapter03;

/*
 *线程安全的初始化方案
 * 利用类的初始化来完成
 *
 * 如果确实需要对实例字段使用线程安全的延迟初始化，请使用上面介绍的基于volatile的延迟初始化的方案；
 * 如果确实需要对静态字段使用线程安全的延迟初始化，请使用上面介绍的基于类初始化的方案。
 * */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //这里将导致InstanceHolder初始化
    }

    static class Instance {
    }
}
