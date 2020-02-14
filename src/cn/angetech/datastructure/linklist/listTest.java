package cn.angetech.datastructure.linklist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class listTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("guan");
        list.add("bao");
        System.out.println(list);
        // [guan, bao]


        String[] array = list.toArray(new String[0]);
        System.out.println(array);
        // [Ljava.lang.String;@1540e19d
        System.out.println(array.toString());


        String[] str = new String[]{"guan","bao"};
        System.out.println(str);
        List list2 = Arrays.asList(str); // asList的返回对象是一个Arrays内部类，并没有实现集合的修改方法。体现的是适配器模式，只是转换接口，
        System.out.println(list2);
        // 不支持
        // list2.add("dd");
        System.out.println(list.equals(list2)); // 但数据相等
        System.out.println(list2.equals(list)); // 但数据相等


        List<String> list3 = new ArrayList<>();
        list3.add("11");
        list3.add("22");
        Iterator<String> iterator = list3.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            iterator.remove();
        }
        System.out.println(list3);

    }
}
