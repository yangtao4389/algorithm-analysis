package cn.angetech.javademo.io.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/*
*SocketChannel 用于创建基于tcp协议的客户端对象
* https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247484949&amp;idx=1&amp;sn=a8a9c3fcf736efa88917e8c32db35758&source=41#wechat_redirect
* */
public class WebClient {
    public static void main(String[] args) throws Exception{
        /*
        * 1.创建socket channel
        * 2. 创建写buffer  写入到 socket
        * 3. 创建读 buffer 读取从服务端 返回的byte
        * 4. 判断是否读完
        * 5. 关闭
        *
        * */

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1",3333));

        //2.
        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.put("this is client".getBytes("UTF-8"));
        writeBuffer.flip();
        socketChannel.write(writeBuffer);


        //3.
        ByteBuffer readBuffer = ByteBuffer.allocate(128);
        socketChannel.read(readBuffer);

        StringBuilder stringBuffer = new StringBuilder();
        System.out.println(readBuffer);
        readBuffer.flip();
        int num = 0;
        while (readBuffer.hasRemaining()){
//            System.out.println("hasRemaining");
            num += 1;
            stringBuffer.append((char) readBuffer.get());

        }
        System.out.println(num);
        System.out.println("从服务器端 接受的数据："+stringBuffer);

        socketChannel.close();


    }

}
