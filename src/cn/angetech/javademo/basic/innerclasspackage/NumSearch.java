package cn.angetech.javademo.basic.innerclasspackage;

public class NumSearch {
    int num = 10;
    class InNumSearch{
        int num = 20;
        public void inNumShow(){
            int num = 30;
            System.out.println(num);
        }
    }

    public void test(){
        InNumSearch inNumSearch = new InNumSearch();
        System.out.println(inNumSearch.num);
        inNumSearch.inNumShow();
    }

    public void test2(){
        System.out.println(num);
        System.out.println(this.num);
        System.out.println(NumSearch.this.num);
    }

    public static void main(String[] args) {
        NumSearch numSearch = new NumSearch();
//        System.out.println(numSearch.num);
//        numSearch.test();
        numSearch.test2();


    }


}
