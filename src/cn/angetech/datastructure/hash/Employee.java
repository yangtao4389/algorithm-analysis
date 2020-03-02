package cn.angetech.datastructure.hash;

import java.util.HashMap;
import java.util.Map;

public class Employee <AnyType>{
    public static void main(String[] args) {
        String a= "ddd";
        System.out.println(a.hashCode());
        System.out.println(a.hashCode());
        System.out.println(hash(a,70));
//        System.out.println("0".hashCode());

        int c = 1;
        System.out.println(myhash(c));  // 这样就可以，好奇怪。
        // System.out.println(c.hashCode());  // todo 这样就有问题
        System.out.println(myhash(a));


        Map<String,String> map = new HashMap<>();
        map.put("yang","hello");  // tab 6--> 9
        map.put("y","y");
        map.put("yy","yy");
        map.put("yyy","yyy");
        map.put("xx","xx");
        map.put("xxx","xxx");
//        System.out.print( map.put("y","hello"));

        int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
        System.out.println(DEFAULT_INITIAL_CAPACITY);


    }


    public static int hash(String key, int tableSize){
        int hashVal = 0;
        for (int i=0;i<key.length();i++){
            hashVal = 31*hashVal + key.charAt(i);
        }
        hashVal %= tableSize;
        return hashVal;
    }

    public boolean equals(Object rhs){
        return rhs instanceof Employee && name.equals(((Employee)rhs).name);
    }
    public int hashCode(){
        return name.hashCode();
    }
    private String name;
    private double salary;
    private int seniority;

    private static<AnyType> int myhash(AnyType x){
        int hashVal = x.hashCode();
        return hashVal;
    }
}
