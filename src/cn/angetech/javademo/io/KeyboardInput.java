package cn.angetech.javademo.io;

import java.io.*;
import java.util.Scanner;

/*
* 键盘输入
* */
public class KeyboardInput {
    public static void main(String[] args) throws IOException {
//        scannerTest();
//        scannerTest2();
//        scannerTest3();
//        scannerTest4();
//        streamReader();
//        streamTest();
        IOReceive();
    }

    public static void scannerTest(){
        /*
        * 可以从控制台一直输入信息进来
        * */
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            // todo 通过ctrl+d 或者ctrl+z(windows上不行) 进行终止输入
            String s = scanner.next();
            System.out.println(s);
        }



//        String s = scanner.next();
//        System.out.println(s);
    }

    public static void scannerTest2(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }
    public static void scannerTest3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你的年龄：");
        String age = sc.nextLine();
        System.out.println("请输入你的工资：");
        String salary = sc.nextLine();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }
    public static void scannerTest4(){
        /*
        * todo 这里先读取 sc.nextInt()  过后的nextLine 吸收了这里的回车符 所以直接跳转到工资 所以正确的是使用 next()
        *
        * */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的姓名：");
//        String name = sc.nextLine();
        String name = sc.next();
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }

    public static void streamReader() throws IOException {
        /*
        * 只能从控制台 获取一个字符串
        *
        * */

        System.out.println("请输入：");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while(bufferedReader.read() != -1){  //实现持续读入
            int read = bufferedReader.read();
            System.out.println((char) read);
        }
        String s = bufferedReader.readLine();
        System.out.println(s);
    }

    public static void streamTest() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
        byte[] bytes = new byte[3];

        int read = bufferedInputStream.read(bytes);
        System.out.println(read);
//        for (byte b:bytes){
//            System.out.println(b);
//        }
        System.out.println(new String(bytes));

    }

    public static void IOReceive() throws IOException {
        int receive = 0;
        while ((receive = System.in.read())!= -1){
            System.out.print((char)receive);
            System.out.print("---");
            System.out.print(receive);
            System.out.println();
        }
    }

}
