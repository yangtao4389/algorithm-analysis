package cn.angetech.datastructure.map;

import java.util.*;

public class CoumputeWords {

    public static void main(String[] args) {
//        System.out.println(oneCharOff("wore","werd"));

        List<String> theWords = new ArrayList<>();
        theWords.add("wine");
        theWords.add("wind");
        System.out.println(theWords);
        System.out.println(theWords.get(1));


        String a = "abc";
        System.out.println(a.substring(0,1));  // 包含begin  不包含 end
        System.out.println(a.substring(1));


        Map<String,List<String>> words = computeAdjacentWords(theWords);
        System.out.println(words);
    }


    /*
    * 给出包含一些单词作为关键字 和 只在一个字母上 不同的一列 单词 作为关键词的值 输出
    * 那些 具有 minWords个 或 更多个 通过1 字母 替换得到的单词的单词
    *
    * {"wine",[wind,wing,wink,wins]}  3
    * */
    public static void pringHighChangeables(Map<String,List<String>> adjWords, int minWords){
        for (Map.Entry<String,List<String>> entry:adjWords.entrySet()){
            List<String> words = entry.getValue();  // [wind,wing,wink,wins]

            if(words.size() >= minWords){  // 要提取能改变成15个以上的单词
                System.out.print(entry.getKey() + "(");  //wine(16):wind wing wink wins
                System.out.print(words.size() + "):");
                for (String w:words)
                    System.out.print(" "+w);
                System.out.println();
            }
        }
    }



    /*
    *  检测两个单词是否只在一个字母上不同
    * */
    private static boolean oneCharOff(String word1, String word2){
        if(word1.length() != word2.length()){
            return false;
        }

        int diffs = 0;
        for (int i=0;i<word1.length();i++)
            if(word1.charAt(i) != word2.charAt(i))
                if( ++diffs >1)  // todo
                    return false;
        return diffs == 1;
    }

    private static<keyType> void update(Map<keyType,List<String>> m,keyType key,String value){  // static<keyType>
        List<String> lst = m.get(key);
        if(lst == null){
            lst = new ArrayList<String>();
            m.put(key,lst);
        }
        lst.add(value);
    }

    /*
    * 该对象 以 一些单词 作为关键字 而只在一个字母处不同的一列单词 作为关键字的值
    * 传入：[wine,wind]
    * 返回：{wind=[wine],  wine = [wind] }
    *
    * 该算法对 89000 个单词的输入 分类结束为 96秒
    * */
//    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords){
//        Map<String,List<String>> adjWords = new TreeMap<String, List<String>>();
//        String[] words = new String[theWords.size()];
//
//        System.out.println(theWords);
//        // 列表转为数组
//        theWords.toArray(words);  //
//        System.out.println(words.length);
//        for(int i=0;i<words.length;i++) {
//            for (int j = i+1;j<words.length;j++){
//                if(oneCharOff(words[i],words[j])){
//                    update(adjWords, words[i], words[j]);
//                    update(adjWords,words[j],words[i]);
//                }
//            }
//        }
//        return adjWords;
//    }


    /*
    * 改进1
    * 避免比较不同长度的单词
    *
    * 用映射：关键字是整数，值代表该长度的所有单词的集合
    *
    * 只需要51秒 速度增一倍
    *
    * */
//    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords) {
//        Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
//        Map<Integer, List<String>> wordByLength = new TreeMap<Integer, List<String>>();
//
//
//        // group the words by their length
//        for (String w : theWords) {
//            update(wordByLength, w.length(), w);
//        }
//
//        for (List<String> groupsWords : wordByLength.values()) {
//            String[] words = new String[groupsWords.size()];
//            groupsWords.toArray(words);  //todo  数组才有下标，列表没有？ 列表用 get
//            for (int i = 0; i < words.length; i++)
//                for (int j = i + 1; j < words.length; j++)
//                    if (oneCharOff(words[i], words[j])) {
//                        update(adjWords, words[i], words[j]);
//                        update(adjWords, words[j], words[i]);
//                    }
//        }
//        return adjWords;
//    }


    /*
    * 改进2
    * 更为快速的方法  4s 解决
    *
    *
    * 1. 还是先对 长度一致的 单词 分为一组
    *
    * 2. 对于该长度一致的 从0，到该长度 将单词切片
    *    比方：ab,ac  切0  剩下的 为 b,c  存入[b:[ab],  c:[ac] ]
    *                 切1  剩下的 为 a   存入 {a:[ab,ac] }  这个>=2  取出  相互遍历
    *
    *
    *
    *
    * */
    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords) {
        Map<String, List<String>> adjWords = new TreeMap<String, List<String>>();
        Map<Integer, List<String>> wordByLength = new TreeMap<Integer, List<String>>();


        // group the words by their length
        for (String w : theWords) {
            update(wordByLength, w.length(), w);
        }

        // wordByLength  {1:[a,b,c,d,e,f,...], 2:[ab,cd,ef,ge,...]}
        for(Map.Entry<Integer,List<String>> entry:wordByLength.entrySet()){
            List<String> groupswords = entry.getValue();
            int groupNum = entry.getKey();

            for(int i=0;i<groupNum;i++){  // {2,[ab,bc,cd,]}
                Map<String,List<String>> repToWord = new TreeMap<>();

                for (String str:groupswords){  //
                    String rep = str.substring(0,i) +str.substring(i+1);
                    update(repToWord, rep,str);
                }

                System.out.println(repToWord);
                for(List<String> wordClique: repToWord.values()){
                    if (wordClique.size() >= 2){
                        for (String s1:wordClique){
                            for (String s2:wordClique){
                                if (!s1.equals(s2)){
                                    update(adjWords,s1,s2);
                                }
                            }
                        }
                    }
                }


            }
        }
        return adjWords;


    }


}
