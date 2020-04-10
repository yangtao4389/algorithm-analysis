package cn.angetech.algorithm.javaguide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* 栈的压入,弹出序列 https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
*
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
* （注意：这两个序列的长度是相等的）
*
*   分析
*   1,2,3,4  弹出4
*   1,2,3,5 弹出 5
*   1,2,3， 弹出 3,2,1
*
*   1,2,3,4  弹出4
*   1,2,3,  弹出3
*   1,2,5  弹出5
*   1,2, 弹出2,1
*
*
1,2,3,4,5 压入顺序的话：
5,4,3,2,1 是弹出栈

弹出栈5 跟 原始栈对比 找到后
将原始栈 1234  放入临时栈


先跟临时栈的最后一个对比 如果等于 则 临时栈 去掉








*
*
*
*
* */
public class Class20 {
    public static void main(String[] args) {
        boolean b = new Class20().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 2});
        System.out.println(b);
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int len = pushA.length;
        ArrayList<Integer> tmpA = new ArrayList<>();

        int pushAIndex = 0;
        int popAIndex = 0;

        int popAIndexNum;
        int tmpANum = Integer.MIN_VALUE;


        for (; popAIndex < len; popAIndex++) {
            int popANum = popA[popAIndex];
            if (popANum != tmpANum) { // 只能往后找  在后面，或者不在后面
                while (pushAIndex < len && pushA[pushAIndex] != popANum) {
                    tmpANum = pushA[pushAIndex];
                    tmpA.add(tmpANum);
                    pushAIndex++;
                }
                // 过滤掉得到的该数组
                pushAIndex++;

            } else {
                tmpA.remove(tmpA.size() - 1);
                if(tmpA.size() == 0){
                    tmpANum = Integer.MIN_VALUE;
                }else {
                    tmpANum = tmpA.get(tmpA.size() - 1);
                }

            }

            System.out.println(tmpA);
        }
        if(tmpA.size() == 0){
            return true;
        }

        return false;
    }

    /*
    *
    * 其它解法
    * 链接：https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
来源：牛客网

入栈1,2,3,4,5

出栈4,5,3,2,1

首先1入辅助栈，此时栈顶1≠4，继续入栈2

此时栈顶2≠4，继续入栈3

此时栈顶3≠4，继续入栈4

此时栈顶4＝4，出栈4，弹出序列向后一位，此时为5，,辅助栈里面是1,2,3

此时栈顶3≠5，继续入栈5

此时栈顶5=5，出栈5,弹出序列向后一位，此时为3，,辅助栈里面是1,2,3
    * */
    public boolean IsPopOrder2(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    /*自己写一遍*/
    public boolean IsPopOrder3(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;

        // 临时栈
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        // 将 pushA  都往 临时栈添加 使用for
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            // 将添加后 临时栈的 栈顶 与 popA 对比  如果相等 则出栈  不等 则 continue
            while (!stack.empty()&&stack.peek() == popA[popIndex]){  // 这个while是在第一次结束后，则需要判断第二次 所以使用了while
                stack.pop();
                popIndex ++;
            }
        }
        return stack.empty();

    }
}
