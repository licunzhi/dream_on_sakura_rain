package com.sakura.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * @ClassName ClassInfo
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/09/26 19:12
 */
public class ClassInfo {
    public static void main(String[] args) throws IOException {
        Bean bean = new Bean();
        bean.setAge(12);
        bean.setName("sakura");
        bean.setDate(new Date());


        FileOutputStream fileOutputStream = new FileOutputStream("./sakura.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bean);

        objectOutputStream.close();
    }
}
