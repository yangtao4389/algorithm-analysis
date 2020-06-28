package cn.angetech.javademo.basic.innerclasspackage;

public class Cow {
    private double weight;

    public Cow(){}
    public Cow(double weight){
        this.weight = weight;
    }

    // 定义一个非静态内部类
    private class CowLeg{
        private double length;
        private String color;
        public CowLeg(){}
        public CowLeg(double length,String color){
            this.length = length;
            this.color = color;
        }
        public void info(){
            System.out.println("颜色："+color+"高"+length);
            System.out.println("重："+weight);
        }

    }


    public void test(){
        CowLeg cowLeg = new CowLeg(1.2, "white");
        cowLeg.info();
    }

    public static void main(String[] args) {
        Cow cow = new Cow(500);
        cow.test();

    }


}
