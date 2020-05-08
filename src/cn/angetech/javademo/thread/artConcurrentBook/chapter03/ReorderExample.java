package cn.angetech.javademo.thread.artConcurrentBook.chapter03;

public class ReorderExample {
    int a = 0;
    volatile boolean flag = false;
    public void writer() throws InterruptedException {
        a = 1;
        flag = true;

        Thread.sleep(100);
    }

    public void reader(){
        if (flag){
            int i = a*a;
            System.out.println("flag:"+i); // todo 无论如何也重现不了 flag等于0的情况
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ReorderExample example =  new ReorderExample();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    example.writer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.reader();
            }
        });
        t2.start();
        t1.start();



        t1.join();
        t2.join();
        System.out.println("end");
    }
}
