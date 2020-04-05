package cn.angetech.javademo.io.nio;

import com.sun.corba.se.impl.legacy.connection.LegacyServerSocketManagerImpl;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
* ServerSocketChannel 允许我们监听TCP链接请求，通过ServerSocketChannelImpl的 accept()方法 可以创建一个SocketChannel对象用户从客户端读/写数据。
* * https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247484949&amp;idx=1&amp;sn=a8a9c3fcf736efa88917e8c32db35758&source=41#wechat_redirect
* */
public class WebServer {
    public static void main(String[] args) {
        /*
        * 每个请求 有的会出错 有的不会 所以 让服务器一直跑着 全局使用 try catch
        *
        * 1.创建socket 对象
        * 2. socket accept
        * 3. 当有链接时  创建buffer 接收数据 写入到
        *
        *
        * */
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",3333));
            SocketChannel socketChannel = serverSocketChannel.accept();

            ByteBuffer byteBuffer = ByteBuffer.allocate(128);
            byteBuffer.clear();
            socketChannel.read(byteBuffer);
            StringBuffer stringBuffer = new StringBuffer();
            System.out.println(byteBuffer);  //java.nio.HeapByteBuffer[pos=18 lim=128 cap=128]
            byteBuffer.flip();  // 从头再读
            while (byteBuffer.hasRemaining()){
                stringBuffer.append((char) byteBuffer.get());
            }
            System.out.println("获取客户端数据："+stringBuffer);

            byteBuffer.clear();
            byteBuffer.put(String.valueOf(stringBuffer).getBytes());
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            socketChannel.close();
            serverSocketChannel.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
