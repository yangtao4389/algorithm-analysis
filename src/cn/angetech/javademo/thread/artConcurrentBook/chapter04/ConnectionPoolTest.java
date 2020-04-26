package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/*
* 模拟客户端获取，使用，释放 连接的过程  线程池
*
* */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);  // 线程池总共10条

    // 保证所有 ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        int threadCount = 200; // 多少个线程并发获取// todo 本地机器跑的时候，当线程达200 这个数时，未获取到连接的次数为50%的比例
        end = new CountDownLatch(threadCount);
        int count = 1; //
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: "+(threadCount*count));
        System.out.println("got connection: "+ got);
        System.out.println("not got connection "+ notGot);
        System.out.println("end:"+Profiler.end());
    }

    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }


        @Override
        public void run() {
            try{
                start.await();
            }catch (Exception ex){}

            // 每个线程 执行count次 connection 连接
            while (count>0){
                // 从线程池中获取连接，如果1000ms无法获取到，将会返回null
                // 分别统计连接获取的数量got和未获取到的数量notGot
                try{
                    Connection connection = pool.fetchConnection(1000);
                    if (connection !=null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }

                }catch (Exception ex){

                }finally {
                    count --;
                }
            }
            end.countDown();
        }
    }




}
