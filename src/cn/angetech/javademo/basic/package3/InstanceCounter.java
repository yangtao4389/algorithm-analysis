package cn.angetech.javademo.basic.package3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InstanceCounter {
    private static  int numInstances = 0;
    private static AtomicInteger atomicInteger =  new AtomicInteger(0);
    protected static int getCount(){
        return numInstances;
    }
    protected static int getCount2(){
        return atomicInteger.get();
    }
    private static  void addInstance(){
        numInstances++;
        for (;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }


    }
    InstanceCounter(){
        InstanceCounter.addInstance();
    }

    public static void main(String[] args) {
        System.out.println("starting with "+
        InstanceCounter.getCount() + "instances");
//        for (int i = 0; i < 500; i++) {
//            new InstanceCounter();
//        }
//        System.out.println("created:"+
//        InstanceCounter.getCount() + "instances");

        ArrayList<Thread> ts = new ArrayList<>(600);
        for (int i = 0; i < 1000; i++) {

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        new InstanceCounter();
                    }

                }
            });
            ts.add(t);
        }

        for (Thread t:ts){
            t.start();
        }
        for (Thread t:ts){
            try{
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("created:"+ InstanceCounter.getCount() + "instances");
        System.out.println("created:"+ InstanceCounter.getCount2() + "instances");

    }

}
