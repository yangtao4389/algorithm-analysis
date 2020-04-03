package cn.angetech.javademo.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IOServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(3333);
        new Thread(()->{
            while (true){
                try{
                    Socket socket = serverSocket.accept();
                    // 每一个新的连接 创建一个线程，负责 读取数据
                    new Thread(()->{
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            while ((len=inputStream.read(data))!= -1){
                                System.out.println(new String(data,0,len));  // 字节转换为 String

                            }
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }).start();
                }catch (IOException e){
                    e.printStackTrace();
                }

            }
        }).start();


    }

}
