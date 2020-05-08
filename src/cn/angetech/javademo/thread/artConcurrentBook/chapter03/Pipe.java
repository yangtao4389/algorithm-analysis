package cn.angetech.javademo.thread.artConcurrentBook.chapter03;

import java.io.*;

/*通过管道，实现main线程的读  从线程的打印*/
public class Pipe {

    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        //in.connect(out);

        Thread thread = new Thread(new Print(in), "printThread");
        thread.start();
        int receive =0;
        while ((receive = System.in.read())!=-1){
            out.write(receive);
        }


    }


    private static class Print implements Runnable{
        PipedReader in;
        Print(PipedReader in){
            this.in = in;
        }

        @Override
        public void run(){
            int receive = 0;
            try{
                while ((receive=in.read())!=-1){
//                    System.out.println("get receive:");
                    System.out.print((char)receive);
//                    System.out.println();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

}
