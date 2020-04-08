package cn.angetech.algorithm.huawei;

import java.util.*;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class JiuGongGe {


    /*
    * 执行用时 :7 ms, 在所有 Java 提交中击败了26.20%的用户
        内存消耗 :38.5 MB, 在所有 Java 提交中击败了5.21%的用户
    *
    * */
    public List<String> letterCombinations(String digits) {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        List<String> arrayList = new ArrayList<>();
        for (char i :digits.toCharArray()){
            String[] strings = map.get(Character.toString(i));
            System.out.println(Arrays.toString(strings));
            // 第二次怎么加？？
            if(arrayList.isEmpty()){
                for (String s:strings){
                    arrayList.add(s);
                }
            }else {
                int arrayListSize = arrayList.size();
                for (int j=0;j<arrayListSize;j++){
                    for (String s:strings){
                        arrayList.add(arrayList.get(j)+s);
                    }
                }
                System.out.println(arrayList);
                arrayList = arrayList.subList(arrayListSize, arrayList.size());
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        new JiuGongGe().letterCombinations("233");
    }
}
