package cn.angetech.datastructure.map;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dd","dd1");
        hashMap.put("dd","dd2");  // 重复输入 不会出现问题 只会替换
        System.out.println(hashMap);

    }

}
