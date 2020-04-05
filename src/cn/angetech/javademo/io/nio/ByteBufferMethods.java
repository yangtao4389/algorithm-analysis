package cn.angetech.javademo.io.nio;


import java.nio.ByteBuffer;

/*
* 用于测试nio 的 缓冲区 方法
* nio 分为 缓冲区 跟 管道。
* 管道写入缓冲区 以及从缓冲区拿取数据
* */
public class ByteBufferMethods {
    public static void main(String[] args) {
        // 分配缓冲区
        // 设置 position
        ByteBuffer buffer =  ByteBuffer.allocate(24);
        System.out.println("-------------test--reset------------------");
        buffer.clear();
        buffer.position(10);
        System.out.println(buffer);  //java.nio.HeapByteBuffer[pos=10 lim=24 cap=24]
        buffer.mark();
        System.out.println(buffer); //java.nio.HeapByteBuffer[pos=10 lim=24 cap=24]





    }

}
