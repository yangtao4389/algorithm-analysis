package cn.angetech.javademo.basic;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.CORBA.OBJ_ADAPTER;

import java.io.*;

/*
 * 序列化测试
 *
 * */
public class SerializableTest {
    private static void seriallizeObjToFile() throws IOException {
        Person person = new Person("yy", 1);
        Person person2 = new Person("name2", 12);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));

        objectOutputStream.writeObject(person);
        objectOutputStream.writeObject(person2);
        objectOutputStream.writeObject(person);
//        objectOutputStream.writeObject(person2);

    }

    private static void fileToObj() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person person =  (Person) objectInputStream.readObject();
        Person person2 =  (Person) objectInputStream.readObject();
        Person person3 =  (Person) objectInputStream.readObject();


        System.out.println(person == person3);


    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        seriallizeObjToFile();
        fileToObj();

    }
}

class Person implements Serializable {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pserson{" +
                "name=" + this.name +
                ",age=" + age +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person that = (Person) obj;
            System.out.println("比较两个name");
            System.out.println(this.name);
            System.out.println(that.name);
            System.out.println(this.hashCode() == that.hashCode());  // false


            if (this.name.equals(that.name)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
