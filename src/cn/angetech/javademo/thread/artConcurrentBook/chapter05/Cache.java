package cn.angetech.javademo.thread.artConcurrentBook.chapter05;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
* 利用读写锁  来实现缓存
* 可以共享读  但只能唯一写
*
* */
public class Cache {
    static Map map = new HashMap<String,Object>();
    static ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    static Lock r = rw1.readLock();
    static Lock w = rw1.writeLock();

    // 获取key对应的value
    public static final Object get(String key){
        r.lock();
        try{
            return  map.get(key);
        }finally {
            r.unlock();
        }
    }

    public static final Object put(String key,Object value){
        w.lock();
        try{
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }

    public static final void clear(){
        w.lock();
        try {
            map.clear();

        }finally {
            w.unlock();
        }
    }

     static class Job extends Thread{
        private int num;
        public Job(int num){
            this.num = num;
        }

         @Override
         public void run() {
             System.out.println("dd"+num);
             Cache.put("dd",num);

         }
     }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread  thread =  new Job(i);
            thread.setName(""+i);
            thread.start();
        }
        System.out.println(Cache.get("dd"));
        System.out.println(Cache.map);

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Cache.get("dd"));
                    System.out.println("end");
                }
            }).start();
        }

    }

}
