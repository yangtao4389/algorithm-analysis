package cn.angetech.algorithm.greedy;

import java.util.Arrays;

public class Greedy {

    public void greedy1(){

        int[] values = {1,2,5,10,20,50,100};
        int[] counts = {3,3,2,1,1,3,3};
        int[] result = getNumber1(446,values,counts);
        System.out.println(Arrays.toString(result));
    }

    /*
    * 钱币找零问题
    * 总额
    * 面值
    * 数量
    * */
    public int[] getNumber1(int sum,int[] values,int[] counts){
        int[] result = new int[7];
        int add = 0;
        for (int i=values.length-1;i>=0;i--){
            int num = (sum-add)/values[i];
            if (num>counts[i]){
                num = counts[i];
            }
            add = add + num*values[i];
            result[i] = num;
        }
        return result;
    }
}
