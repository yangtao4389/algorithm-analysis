package cn.angetech.datastructure.linklist;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class diedaiqi {
    public static void main(String[] args) {
        String[] planets = new String[]{"venus","Earth","Mars","Pluto"};
        List list = Arrays.asList(planets);
        System.out.println("list="+list);

        ListIterator it = list.listIterator();
        System.out.println("it.next()="+it.next());
        System.out.println("it.next()="+it.next());
        System.out.println("it.next()="+it.next());
        System.out.println("it.next()="+it.next());
//        System.out.println("it.next()="+it.next());
        System.out.println("it.previous()="+it.previous());
        System.out.println("it.previous()="+it.previous());

    }
}
