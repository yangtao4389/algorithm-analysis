package cn.angetech.javademo.basic.innerclasspackage;

public class Outer {
    public static class Inner{
        static int num1 = 10;
        int num2 = 20;
    }

    public static void main(String[] args) {
        Inner inner = new Inner();
        System.out.println(inner.num2);
        System.out.println(Inner.num1);
        System.out.println(inner.num1);
        System.out.println(Inner.num1);




    }
}
