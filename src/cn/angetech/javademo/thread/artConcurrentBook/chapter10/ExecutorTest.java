package cn.angetech.javademo.thread.artConcurrentBook.chapter10;


import java.util.concurrent.Executor;

public class ExecutorTest {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
    }

}
