package cn.angetech.javademo.thread.artConcurrentBook.chapter06;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentPutHashMap {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        HashMap<String, String> map = new HashMap<>();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
//                            stringStringConcurrentHashMap.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
        // Thread.sleep(10000);
        while (true){
            System.out.println(map); // todo 在读取的时候就会报错  HashIterator.nextNode  java.util.ConcurrentModificationException
//            System.out.println(stringStringConcurrentHashMap);
        }

    }
}
