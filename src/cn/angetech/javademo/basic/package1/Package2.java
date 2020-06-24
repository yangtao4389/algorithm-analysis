package cn.angetech.javademo.basic.package1;

public class Package2 {

    void show(){
        PrivateClass privateClass = new PrivateClass();
//        privateClass.privateFunction();
        privateClass.publicFunction();
        privateClass.defaultFunction();
        privateClass.protectedFunction();
//        privateFunction();
//        defaultFunction();
//        protectedFunction();
//        publicFunction();


        // 对变量的访问  跟方法一样
//        System.out.println(privateClass.privateVar);
        System.out.println(privateClass.defaultVar);
        System.out.println(privateClass.protectedVar);
        System.out.println(privateClass.publicVar);

//        System.out.println(privateVar);
//        System.out.println(defaultVar);
//        System.out.println(protectedVar);
//        System.out.println(publicVar);



    }

    public static void main(String[] args) {
        // 同一个包下的不同类，能调用除private以外的所有属性的方法
        // 对对象的访问，一通过实例化  二 通过直接访问
        PrivateClass privateClass = new PrivateClass();
//        privateClass.privateFunction();
        privateClass.publicFunction();
        privateClass.defaultFunction();
        privateClass.protectedFunction();

        // 对变量的访问  跟方法一样
//        System.out.println(privateClass.privateVar);
        System.out.println(privateClass.defaultVar);
        System.out.println(privateClass.protectedVar);
        System.out.println(privateClass.publicVar);


    }
}
