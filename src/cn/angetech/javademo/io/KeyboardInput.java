package cn.angetech.javademo.io;

import java.io.*;
import java.util.Scanner;

/*
* 键盘输入
* */
public class KeyboardInput {
    public static void main(String[] args) throws IOException {
//        scannerTest();
//        streamReader();
        streamTest();
    }

    public static void scannerTest(){
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(s);
    }

    public static void streamReader() throws IOException {
        System.out.println("请输入：");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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

}
