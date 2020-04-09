package cn.angetech.algorithm.sort;


import java.util.TreeMap;

/*
* 重写 compare 方法
* 实现person类 按年龄来排序
*
* */
public class PersonSortAtAge {
    static class Person implements Comparable<Person>{
        private String name;
        private int age;
        public Person(String name,int age){
            this.name = name;
            this.age     = age  ;
        }

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

        @Override
        public int compareTo(Person o) {
            // 直接这样写有问题  当age一样的时候就出现问题了 因为它对0好像不判断
            // 改成三元表达式
            return (this.age-o.age)>0?1:-1;


        }
    }

    public static void main(String[] args) {
        TreeMap<Person, String> personStringTreeMap = new TreeMap<>();
        personStringTreeMap.put(new Person("张三",30),"zhangsan");
        personStringTreeMap.put(new Person("李四",19),"lisi");
        personStringTreeMap.put(new Person("老二",30),"laoer");
        personStringTreeMap.put(new Person("老大",50),"laoda");

        for (Person key:personStringTreeMap.keySet()){
            System.out.println(key.getAge()+"---"+key.getName());
        }
    }
}
