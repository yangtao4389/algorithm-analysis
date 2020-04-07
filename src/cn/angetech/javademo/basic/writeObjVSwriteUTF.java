package cn.angetech.javademo.basic;

import java.io.*;
import java.util.Arrays;

public class writeObjVSwriteUTF {
    public static void main(String[] args) throws IOException {
//        writeTest();
        System.out.println(0xFFFFL);  // 65535

        FileOutputStream fileOutputStream = new FileOutputStream("dd.txt");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
        dataOutputStream.writeUTF("first");
        dataOutputStream.writeUTF("second");
        dataOutputStream.writeUTF("third");
        dataOutputStream.writeInt(122);

//        FileReader fileReader = new FileReader("");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String s = bufferedReader.readLine();

//        InputStreamReader inputStreamReader = new InputStreamReader();

    }

    public static void writeTest() throws IOException {
        ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
        ObjectOutputStream oss1 = new ObjectOutputStream(bos1);

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        ObjectOutputStream oss2 = new ObjectOutputStream(bos2);




        String testString = "fisrt";
        oss1.writeObject(testString);
        oss2.writeUTF(testString);

        testString = "second";
        oss1.writeObject(testString);
        oss2.writeUTF(testString);

        testString = "third";
        oss1.writeObject(testString);
        oss2.writeUTF(testString);

        oss1.flush();
        oss2.flush();

        byte[] bytes = bos1.toByteArray();
        System.out.println(Arrays.toString(bytes));
        // [-84, -19, 0, 5, 116, 0, 5, 102, 105, 115, 114, 116, 116, 0, 6, 115, 101, 99, 111, 110, 100, 116, 0, 5, 116, 104, 105, 114, 100]
        byte[] bytes1 = bos2.toByteArray();
        System.out.println(Arrays.toString(bytes1));
        // [-84, -19, 0, 5, 119, 22, 0, 5, 102, 105, 115, 114, 116, 0, 6, 115, 101, 99, 111, 110, 100, 0, 5, 116, 104, 105, 114, 100]

    }

}
