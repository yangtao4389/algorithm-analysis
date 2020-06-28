package cn.angetech.javademo.basic.finalpackage;

public class Son extends Father {
    public static void main(String[] args) {
        String s1= "ijava";
        String s2 = "i"+"java";
        System.out.println(s1 == s2);  // true  常量池

        String s3 = "i";
        String s4 = "java";
        String s5 = s3+s4;
        System.out.println(s1 == s5);  // false 常量池 跟 s5为指向，编译时还未确定
        System.out.println(s1.equals(s5));  // true

        final String s6 = s3+s4;
        System.out.println(s1 == s6); // false


        final String s7 = "i";
        final String s8 = "java";
        String s9 = s7+s8;
        System.out.println(s1 == s9); // true  用final修饰后，为true

    }
}
