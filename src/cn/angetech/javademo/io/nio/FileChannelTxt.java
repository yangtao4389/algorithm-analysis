package cn.angetech.javademo.io.nio;


import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
* 利用nio的 channel buffer 来读取 写入文件
* */
public class FileChannelTxt {
    public static void main(String[] args) throws Exception{
        // 1.分配一个读缓冲区
        // 2. 读channel
        // 3. 写channel
        // 4. 写缓冲区

        // 5. 写完 关闭文件对象

        RandomAccessFile raf = new RandomAccessFile("D:\\AllLearn\\javaLearn\\algorithm-analysis\\src\\cn\\angetech\\javademo\\io\\nio\\FileChannelTxt.txt","rw");
        ByteBuffer byteBuffer = ByteBuffer.allocate(5); // 读写的缓冲空间  通过 byteBuffer.flip() 切换
        FileChannel rafChannel = raf.getChannel();  // 文件通道  并不确定 读还是写

        // 读数据
        int iRead = rafChannel.read(byteBuffer);

        // 测试读取
//        while (iRead != -1){
//            System.out.println("read:"+iRead);
//            //byteBuffer.flip();
//            byteBuffer.clear();  // todo 这一步的必要性
//            iRead = rafChannel.read(byteBuffer);
//        }

        // 读完过后再加  就是追加
        while (iRead != -1){
            System.out.println("read:"+iRead);
            //byteBuffer.flip();
            if(byteBuffer.hasRemaining()){
                System.out.println((char) byteBuffer.getChar());
            }
            byteBuffer.clear();  // todo 这一步的必要性 重复去读byteBuffer字节
            iRead = rafChannel.read(byteBuffer);
        }

        // 读完了 开始写？
        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.clear();
        writeBuffer.put("这是一个美好的日子\n".getBytes());
        //
        writeBuffer.flip();  // todo 读写的转换
        rafChannel.write(writeBuffer);
        raf.close();


    }

}
