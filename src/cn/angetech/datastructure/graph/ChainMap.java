package cn.angetech.datastructure.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
*
* 求词阶
* */
public class ChainMap {

    /*
    * 利用map 表示两个邻接表 和 两个要被连接的单词
    * 同时返回一个map
    *
    * 在该map中，关键字是单词，
    * */
    public static List<String> findChain(Map<String,List<String>> adjacentWords, String first, String second){
        Map<String,String> previousWord = new HashMap<>();
        LinkedList<String> q = new LinkedList<>();

        q.addLast(first);
        while (!q.isEmpty()){
            String current = q.removeFirst();
            List<String> adj = adjacentWords.get(current);

            if (adj!=null){
                for (String adjWord:adj){
                    if (previousWord.get(adjWord) == null){
                        previousWord.put(adjWord,current);
                        q.addLast(adjWord);

                    }
                }
            }
        }

        previousWord.put(first,null);
        return getChainFromPreviousMap(previousWord,first,second);
    }

    public static List<String> getChainFromPreviousMap(Map<String,String> prev, String first, String second){
        LinkedList<String> result = null;
        if (prev.get(second) != null){
            result = new LinkedList<>();
            for (String str= second;str!=null;str = prev.get(str)){
                result.addFirst(str);
            }
        }
        return result;
    }


}
