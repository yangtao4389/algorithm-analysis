package cn.angetech.javademo.basic;


import java.io.*;

/*
 * 强制序列化
 * */
public class ExternalizableTest {
    public static void main(String[] args) throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("experson.txt"));
        objectOutputStream.writeObject(new ExPerson("yyy",11));

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("experson.txt"));
        ExPerson o = (ExPerson)objectInputStream.readObject();
        System.out.println(o);
        System.out.println(o.getName());
        System.out.println(o.getAge());

    }

}

class ExPerson implements Externalizable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ExPerson(){}

    public ExPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 将name反转后写入 二进制流
        StringBuffer reverse = new StringBuffer(name).reverse();
        System.out.println("reverse:"+reverse);
        System.out.println("reverse-toString:"+reverse.toString());

//        out.writeObject(reverse);
        out.writeUTF(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        this.name = ((StringBuffer)in.readObject()).reverse().toString();
        System.out.println(name);
        String name2 = in.readUTF();
        System.out.println(name2);
        this.name = name2;
        this.age = in.readInt();
    }
}
