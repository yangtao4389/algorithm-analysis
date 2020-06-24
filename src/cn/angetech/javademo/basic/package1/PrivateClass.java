package cn.angetech.javademo.basic.package1;

public class PrivateClass {
    public static void main(String[] args) {
        // 同一个类的所有修饰符都可以被调用
        PrivateClass privateClass = new PrivateClass();
        privateClass.privateFunction();
        privateClass.defaultFunction();
        privateClass.protectedFunction();
        privateClass.publicFunction();

    }

    // 成员变量
    private String privateVar = "private";
    String defaultVar = "default";
    protected String protectedVar = "protected";
    public String publicVar = "public";


    // 成员方法
    private void privateFunction(){
        System.out.println(privateVar);
    }
    void defaultFunction(){
        System.out.println(defaultVar);
    }
    protected void protectedFunction(){
        System.out.println(protectedVar);
    }
    public void publicFunction(){
        System.out.println(publicVar);
    }

    class InnerPrivateClass{

    }

}
