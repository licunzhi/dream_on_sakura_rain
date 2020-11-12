package com.knife4j.demo;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @ClassName ZkDataTest
 * @function [业务功能]
 * @Author lcz
 * @Date 2020/11/11 15:29
 */
public class ZkDataTest {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zooKeeper = new ZooKeeper("10.15.42.22:3000", 10000, null);
        String path = "/SIAP/menu/linkmenu";
        String data = new String(zooKeeper.getData(path, false, null));
        System.out.println(data);
    }
}
