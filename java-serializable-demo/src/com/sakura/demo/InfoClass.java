package com.sakura.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @ClassName InfoClass
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/09/26 19:52
 */
public class InfoClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(new File("sakura.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Bean bean = (Bean) objectInputStream.readObject();
        System.out.println(bean.toString());
    }
}
