package cn.angetech.javademo.thread.artConcurrentBook.chapter09;

public class RuntimeTest {
    /*
    * 获取cpu的执行 core 数
    * */
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}
