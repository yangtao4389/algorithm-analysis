package cn.angetech.javademo.thread.artConcurrentBook.chapter07;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdateTest {
    // 创建原子更新器，并设置需要更新的对象类和对象的属性
    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User conna = new User("conna", 10);
        System.out.println(a.getAndIncrement(conna));
        System.out.println(a.get(conna));
    }






    public static class User{
        private String name;
        public volatile int old;
        //private volatile int old;  // java.lang.ExceptionInInitializerError  modifiers "private volatile
        //private int old; // todo 这样会报错 Caused by: java.lang.IllegalAccessException，因为old并没有使用 volatile 来修饰

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

}
