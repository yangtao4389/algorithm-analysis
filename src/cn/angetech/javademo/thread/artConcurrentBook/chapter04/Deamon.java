package cn.angetech.javademo.thread.artConcurrentBook.chapter04;

public class Deamon {

    public static void main(String[] args) {
        Thread thread = new Thread(new DeamonRunner(), "DeamonRunner");
        thread.setDaemon(true);
        thread.start();
    }
    //在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑
    static class DeamonRunner implements Runnable{
        @Override
        public void run() {
            try {
                SleepUtils.second(10);
            }finally {
                System.out.println("DeamonThread finally run.");
            }
        }
    }

}
