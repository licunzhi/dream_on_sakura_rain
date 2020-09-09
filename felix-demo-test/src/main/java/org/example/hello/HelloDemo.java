package org.example.hello;

import org.apache.felix.ipojo.ComponentInstance;
import org.apache.felix.ipojo.Pojo;

/**
 * @ClassName HelloDemo
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/08/09 23:04
 */
public class HelloDemo implements Pojo {

    @Override
    public ComponentInstance getComponentInstance() {
        return null;
    }
}
