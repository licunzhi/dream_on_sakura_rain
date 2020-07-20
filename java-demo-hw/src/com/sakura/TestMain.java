package com.sakura;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName TestMain
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/07/08 10:40
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter(new File("demo.txt"));
        BufferedWriter writer = new BufferedWriter(fileWriter);
        String name = "li";
        String name01 = "cun";
        String name02 = "zhi";
        writer.write(name);
        writer.write(name01);
        writer.write(name02);

        FileInputStream fileInputStream = new FileInputStream(new File("demo.txt"));
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();

        while (s != null) {
            System.out.println(s);
            s = bufferedReader.readLine();
        }
    }
}
