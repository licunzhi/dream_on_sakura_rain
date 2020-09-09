package com.sakura.rain;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * @ClassName TestDemo
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/08/21 22:22
 */
public class TestDemo {
    public static void main(String[] args) {
        String hdfsurl = "hdfs://10.15.42.22:9900/";
        FileSystem fileSystem = null;
        try {
            //获得与hdfs文件系统的连接
            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", hdfsurl);
            conf.setBoolean("fs.hdfs.impl.disable.cache", true);
            conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
//            fileSystem = FileSystem.get(conf);
            Path path = new Path(hdfsurl);
            FileSystem system = path.getFileSystem(conf);
            system.listStatus(path);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileSystem != null) {
                    fileSystem.close();
                }
            } catch (Exception e) {
                System.out.println("error infromation...");
            }
        }

    }
}
