package cn.angetech.javademo.io.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class IOClient {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("localhost",3333);
                while (true){
                    try {
                        // client 写入
                        socket.getOutputStream().write((new Date()+":hello").getBytes());
                       // Thread.sleep(500); // sleep  线程不安全 时间到后 会唤起线程

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

}
