package cn.angetech.javademo.thread.artConcurrentBook.chapter07;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    public static void main(String[] args) {
        User conan = new User("conan", 15);
        atomicUserRef.set(conan);
        User sicha = new User("sicha", 17);
        atomicUserRef.compareAndSet(conan,sicha);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }




    static class User{
        private String name;
        private int old;

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
