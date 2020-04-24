package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
/*
* 管道输入/输出流和普通的文件输入/输出流或者网络输入/输出流不同之处在于，它主要
用于
线程之间的数据传输，而传输的媒介为内存。
管道输入/输出流主要包括了如下4种具体实现：PipedOutputStream、PipedInputStream、
PipedReader和PipedWriter，前两种面向字节，而后两种面向字符。
在代码清单4-12所示的例子中，创建了printThread，它用来接受main线程的输入，任何
main线程的输入均通过PipedWriter写入，而printThread在另一端通过PipedReader将内容读出
并打印
*
* */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流与输入流进行连接
        out.connect(in);
        // todo 启动一个线程读取数据  主线程接受键盘的输入
        Thread thread = new Thread(new Print(in),"printThread");
        thread.start();

        int receive =0;
        try{
            while ((receive = System.in.read())!=-1){
                out.write(receive);
            }
        }finally {
            out.close();
        }
    }
    static class Print implements Runnable{
        private PipedReader in;
        public Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;
            try{
                while ((receive = in.read())!=-1){
                    System.out.print((char) receive);
                }
            }catch (IOException ex){}

        }
    }

}
