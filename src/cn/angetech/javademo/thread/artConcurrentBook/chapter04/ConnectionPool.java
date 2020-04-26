package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.sql.Connection;
import java.util.LinkedList;

/*
* 创建线程池
* 它通过构造函数初始化连接的最大上限，
* 通过一个双向队列来维护连接，
* 调用方需要先调用fetchConnection(long)方法来指定在多少毫秒内超时获取连接，
当连接使用完成后，需要调用releaseConnection(Connection)方法将连接放回线程池，
*
* */
public class ConnectionPool {
    private LinkedList<Connection> pool =  new LinkedList<Connection>();
    public ConnectionPool(int initialSize){
        if (initialSize>0){
            for (int i = 0; i < initialSize; i++) {
                pool.addLast(ConnectionDriver.createConnection());
            }
        }
    }

    public void releaseConnection(Connection connection){
        if (connection !=null){
            synchronized (pool){
                // 连接释放后需要通知 其它消费者 就能感知
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException{
        synchronized (pool){
            // 完全超时
            if (mills<=0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;
                // 超时等等待
                while (pool.isEmpty() && remaining>0){
                    pool.wait();
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }
    }
    


}
