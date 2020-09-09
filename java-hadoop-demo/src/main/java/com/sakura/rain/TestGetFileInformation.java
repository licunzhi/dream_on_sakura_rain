package com.sakura.rain;

import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.net.URI;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName TestGetFileInformation
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/08/28 17:12
 */
public class TestGetFileInformation {
    public static void main(String[] args) {
        String fromPath = "";
        String currentPath = "";
        String toPath = "";
        String searchFileName = null;

        TestGetFileInformation testGetFileInformation = new TestGetFileInformation();

        List<HDFSBrowserModel> fileLists = new ArrayList<>();

        String path = "";
        String hdfsUri = "";

        try {
            if(fromPath!=null && !"".equals(fromPath)){
                path = fromPath;
            }else if(toPath!=null && !"".equals(toPath)){
                path = toPath;
            }else if(currentPath!=null && !"".equals(currentPath)){
                path = currentPath;
            }else if("".equals(path)){
                /*path = hdfsCatalog;*/
            }
            FileStatus[] listStatus = testGetFileInformation.getFileSystem(hdfsUri).listStatus(new Path(path));
            //添加本目录的基本信息
            FileStatus fileStatus = testGetFileInformation.getFileSystem(hdfsUri).getFileStatus(new Path(path));
            HDFSBrowserModel hdfsBrowserModelCurrent = new HDFSBrowserModel();
            hdfsBrowserModelCurrent.setFileName("..");
            hdfsBrowserModelCurrent.setOwner(fileStatus.getOwner());
            hdfsBrowserModelCurrent.setGroup(fileStatus.getGroup());
            hdfsBrowserModelCurrent.setPermission(fileStatus.getPermission().toString());
            String modificationTimec = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(fileStatus.getModificationTime()));
            hdfsBrowserModelCurrent.setModificationTime(modificationTimec);
            hdfsBrowserModelCurrent.setCurrentPath(fileStatus.getPath().toString());
            if(path.endsWith("/")){
                hdfsBrowserModelCurrent.setFromPath(path);
            }else{
                hdfsBrowserModelCurrent.setFromPath(fileStatus.getPath().getParent().toString());
            }
            hdfsBrowserModelCurrent.setIsDir("2");
            fileLists.add(hdfsBrowserModelCurrent);
            //循环添加指定目录下文件夹和文件
            for(FileStatus f : listStatus){
                HDFSBrowserModel hdfsBrowserModel = new HDFSBrowserModel();
                if(f.isDirectory()){
                    hdfsBrowserModel.setFileName(f.getPath().getName());
                    //文件夹不显示大小
                    //hdfsBrowserModel.setLen(Long.toString(f.getLen()));
                    hdfsBrowserModel.setOwner(f.getOwner());
                    hdfsBrowserModel.setGroup(f.getGroup());
                    hdfsBrowserModel.setPermission(f.getPermission().toString());
                    String modificationTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(f.getModificationTime()));
                    hdfsBrowserModel.setModificationTime(modificationTime);
                    hdfsBrowserModel.setCurrentPath(fileStatus.getPath().toString());
                    hdfsBrowserModel.setIsDir("1");
                }
                if(f.isFile()){
                    hdfsBrowserModel.setFileName(f.getPath().getName());
                    hdfsBrowserModel.setLen(FormetFileSize(f.getLen()));
                    hdfsBrowserModel.setOwner(f.getOwner());
                    hdfsBrowserModel.setGroup(f.getGroup());
                    hdfsBrowserModel.setPermission(f.getPermission().toString());
                    String modificationTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(f.getModificationTime()));
                    hdfsBrowserModel.setModificationTime(modificationTime);
                    hdfsBrowserModel.setCurrentPath(f.getPath().toString());
                    hdfsBrowserModel.setIsDir("0");
                }
                if(searchFileName != null && !"undefined".equals(searchFileName)){
                    if(hdfsBrowserModel.getFileName().contains(searchFileName)){
                        fileLists.add(hdfsBrowserModel);
                    }
                }else{
                    fileLists.add(hdfsBrowserModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean getFileSystem(String hdfsUri){
        try {
            if(!hdfsUri.contains("/")) {
                hdfsUri = StringUtils.substringBefore(hdfsUri, "/");
            }
            if(!hdfsUri.contains("hdfs://")) {
                hdfsUri = "hdfs://"+hdfsUri;
            }
            Configuration conf=new Configuration();
            FileSystem.newInstance(new URI(hdfsUri), conf).listStatus(new Path("/"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String FormetFileSize(long fileS)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        String fileSizeString = "";
        if (fileS < 1024){
            fileSizeString = df.format((double) fileS) + "B";
        }
        else if (fileS < 1048576){
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        }
        else if (fileS < 1073741824){
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        }
        else{
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }
}
