package com.sakura;

import java.util.Scanner;

/**
 * @ClassName rain
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/07 17:35
 */
public class rain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.next();
        }
        String[] ruslutStrs = sort(strings);
        for (int i = 0; i <ruslutStrs.length ; i++) {
            System.out.println(ruslutStrs[i]);
        }
    }
    private static String[] sort(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = 0; j < strs.length - i - 1; j++) {
                // M G T

                if (compare(strs[j], strs[j + 1])) {
                    String tem = strs[j];
                    strs[j] = strs[j+1];
                    strs[j+1] = tem;
                }
            }
        }
        return strs;
    }
    private static boolean compare(String str1, String str2){
        int str1M = turnString(str1);
        int str2M = turnString(str2);
        return str1M>str2M;
    }
    private static int turnString(String str){
        if("M".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1));
        }
        else if ("G".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1))*1000;
        }
        else if ("T".equals(String.valueOf(str.charAt(str.length()-1)))){
            return Integer.parseInt(str.substring(0,str.length()-1))*1000000;
        }
        return 0;
    };
}
