package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class SimpleHttpServer {
    // 处理HttpRequest的线程池
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<>(11);  // 但最多为10个线程
    static String bashPath;
    static ServerSocket serverSocket;
    static int port = 8888;

    public static void main(String[] args) throws Exception {
        System.out.println(SimpleHttpServer.port);
        SimpleHttpServer.setPort(1111);
        SimpleHttpServer.setBashPath("docs/ArtConcurrentBook/src/chapter04/static");
        // 请求连接：http://localhost:1111/test1.jpg
        System.out.println(SimpleHttpServer.port);
        SimpleHttpServer.start();
    }

    public static void setPort(int port){
        if (port>0){
            SimpleHttpServer.port = port;
        }
    }
    public static void setBashPath(String bashPath){
        if (bashPath != null && new File(bashPath).exists() && new File(bashPath).isDirectory()){
            SimpleHttpServer.bashPath = bashPath;
        }
    }

    public static void start() throws Exception{
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while ((socket = serverSocket.accept())!=null){
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();

    }




    static class HttpRequestHandler implements Runnable{
        private Socket socket;
        public HttpRequestHandler(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            BufferedWriter writeToHttp = null;
            PrintWriter out = null;
            InputStream in = null;

            try{
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // writeToHttp
//                writeToHttp = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String header = reader.readLine();
                System.out.println("header:"+header);
//                System.out.println("request-method:"+header.split(" ")[0]);
//                System.out.println("request-path:"+header.split(" ")[1]);
//                System.out.println("request-scheme:"+header.split(" ")[2]);

                String filePath = bashPath + header.split(" ")[1];
//                out = new PrintWriter(socket.getOutputStream());
                out = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(socket.getOutputStream())),
                        true);


                if (filePath.endsWith("jpg") || filePath.endsWith("png")){
                    in = new FileInputStream(filePath);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    int i = 0;
                    while ((i = in.read())!= -1){
                        System.out.print(i);
                        byteArrayOutputStream.write(i);
                    }
                    byte[] array = byteArrayOutputStream.toByteArray();
                    // System.out.println(Arrays.toString(array));
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: image/jpeg");
                    out.println("Content-length: "+array.length);
                    out.println("");

//                    writeToHttp.write("HTTP/1.1 200 OK\r\n");
//                    writeToHttp.write("Content-Type: image/jpeg\r\n");
//                    writeToHttp.write("Content-length: \r\n"+array.length);
//                    writeToHttp.write("\r\n");
//                    writeToHttp.write(new String(array) + "\r\n");

                    socket.getOutputStream().write(array,0,array.length);
                }else {
                    br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
                    out = new PrintWriter(socket.getOutputStream());
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: text/html; charset=UTF-8");
                    out.println("");
                    while ((line = br.readLine())!=null){
                        out.println(line);
                    }
                }
                out.flush();
            }catch (Exception ex){
                ex.printStackTrace();
                out.println("HTTP/1.1 500");
                out.println("");
                out.flush();
            }finally {
                close(br,in,reader,out,socket);
            }

        }
        // ... 代表0-n个参数
        private static void close(Closeable... closeables){
            if (closeables != null){
                for (Closeable closeable : closeables) {
                    try{
                        closeable.close();
                    }catch (Exception ex){
                        //
                    }
                }
            }
        }

    }
}
