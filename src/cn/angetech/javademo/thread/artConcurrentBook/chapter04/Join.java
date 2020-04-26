package cn.angetech.javademo.thread.artConcurrentBook.chapter04;


import java.util.concurrent.TimeUnit;

public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previours = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Domino(previours), String.valueOf(i));
            thread.start();
            previours = thread;
        }

        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + "-------.");


    }



    static class Domino implements Runnable{
        private Thread thread;
        public Domino(Thread thread){
            this.thread = thread;
        }

        @Override
        public void run() {
            try{
                thread.join();
            }catch (InterruptedException e){}

            System.out.println(Thread.currentThread().getName() +"terminate.");
        }
    }
}
