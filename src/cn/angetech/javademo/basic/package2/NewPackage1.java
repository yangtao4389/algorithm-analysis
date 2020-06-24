package cn.angetech.javademo.basic.package2;

import cn.angetech.javademo.basic.package1.PrivateClass;

public class NewPackage1 {
    public void show(){
        PrivateClass privateClass = new PrivateClass();
//        privateClass.privateFunction();
//        privateClass.defaultFunction();
//        privateClass.protectedFunction();
        privateClass.publicFunction();
//        privateFunction();
//        defaultFunction();
//        protectedFunction();
//        publicFunction();


        // 对变量的访问  跟方法一样
//        System.out.println(privateClass.privateVar);
//        System.out.println(privateClass.defaultVar);
//        System.out.println(privateClass.protectedVar);
        System.out.println(privateClass.publicVar);

//        System.out.println(privateVar);
//        System.out.println(defaultVar);
//        System.out.println(protectedVar);
//        System.out.println(publicVar);



    }


    public static void main(String[] args) {
        PrivateClass privateClass = new PrivateClass();
//        privateClass.privateFunction();
//        privateClass.defaultFunction();
//        privateClass.protectedFunction();
        privateClass.publicFunction();
//        privateFunction();
//        defaultFunction();
//        protectedFunction();
//        publicFunction();


        // 对变量的访问  跟方法一样
//        System.out.println(privateClass.privateVar);
//        System.out.println(privateClass.defaultVar);
//        System.out.println(privateClass.protectedVar);
        System.out.println(privateClass.publicVar);

//        System.out.println(privateVar);
//        System.out.println(defaultVar);
//        System.out.println(protectedVar);
//        System.out.println(publicVar);
    }

}
