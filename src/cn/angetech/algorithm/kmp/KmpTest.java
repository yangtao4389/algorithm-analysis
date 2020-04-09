package cn.angetech.algorithm.kmp;


import java.util.ArrayList;
import java.util.List;

/*
* 字符串匹配 使用kmp
* java本质的 String 使用的并不是kmp，而是暴力匹配。
* 要考虑使用场景的问题
* kmp 分配了额外的空间，当字符串较大时，会更适合
*
* */
public class KmpTest {
    int[] calculateMaxMatchLengths(String pattern){
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;

        for (int i=1;i<pattern.length();i++){
            while (maxLength>0 && pattern.charAt(maxLength) != pattern.charAt(i)){
                maxLength = maxMatchLengths[maxLength-1];
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)){
                maxLength ++;
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }

    List<Integer> search(String text, String pattern){
        List<Integer> positions = new ArrayList<>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i=0;i<text.length();i++){
            while (count>0 && pattern.charAt(count) != text.charAt(i)){
                count = maxMatchLengths[count-1];
            }
            if (pattern.charAt(count) == text.charAt(i)){
                count ++;
            }
            if (count == pattern.length()){
                positions.add(i-pattern.length() + 1);
                count = maxMatchLengths[count -1];
            }
        }
        return positions;

    }

    public static void main(String[] args) {
        List<Integer> search = new KmpTest().search("qwertiop", "rt");
        System.out.println(search);
    }

}
