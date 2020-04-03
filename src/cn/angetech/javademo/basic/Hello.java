package cn.angetech.javademo.basic;

/*
*
*
* static修饰的代码块称为static代码块，或静态代码块，是在类中独立于类成员的static语句块，一个类中可以有多个static代码块。
* 静态代码块只在第一次加载的时候执行，只执行一次。静态代码块没有名字，因此不能显式调用，而只有在类加载的时候由虚拟机来调用。它主要用来完成一些初始化操作。
*
* 调用构造函数
* 初始化
*
* 继承 先调用父类初始化，再调用子类
*
* 方法重写
* 只调用子类
* */


class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}

class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}

public class Hello {
    public static void main(String[] args) {
        A ab = new B();  // ABab
        System.out.println();
        ab.say();  // 2
        System.out.println();
        ab = new B();  //ab
        System.out.println();
        ab.say(); // 2





    }
}
