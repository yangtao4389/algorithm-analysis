package cn.angetech.datastructure.heap;

public class IntegerComparable implements Comparable<IntegerComparable>{
    public int num;
    public IntegerComparable(int newNum){
        this.num = newNum;
    }

    @Override
    public int compareTo(IntegerComparable o) {
        return this.num - o.num;
    }
}
