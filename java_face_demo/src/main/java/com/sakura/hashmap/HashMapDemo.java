package com.sakura.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-11-27
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String result = map.put("sakura","sakura");
        /*
        * put()操作方法究竟执行了哪些操作
        * params : - key - sakura v- sakura
        * method : putVal(hash(key), key, value, false, true);
        * method : hash(key) --> (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
        * */
        System.out.println(result);
    }
}
