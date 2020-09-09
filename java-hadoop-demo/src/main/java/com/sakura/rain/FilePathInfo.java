package com.sakura.rain;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FilePathInfo
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/08/20 21:39
 */
public class FilePathInfo {


    public static void main(String[] args) throws IOException {
        FilePathInfo filePathInfo = new FilePathInfo();
        filePathInfo.getPathInfo();
    }

    public List<String> getPathInfo() throws IOException {
        ArrayList<String> arrayList = new ArrayList<String>();
        Configuration conf = new Configuration();
        String uri = "hdfs://10.15.42.22:9900/";
        conf.set("fs.defaultFS", uri);
        conf.setBoolean("fs.hdfs.impl.disable.cache", true);
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
        FileSystem fs = FileSystem.get(conf);
        Path path = new Path(uri);

        FileSystem fileSystem = path.getFileSystem(conf);

        FileStatus[] fileStatuses = fileSystem.listStatus(path);
        for (FileStatus fileStatus : fileStatuses) {

            arrayList.add(fileStatus.getPath().toString());

            System.out.println(fileStatus.getPath().toString());
            System.out.println(fileStatus.isDirectory());
            boolean file = fileStatus.isFile();

        }
        fs.close();
        return arrayList;
    }
}
