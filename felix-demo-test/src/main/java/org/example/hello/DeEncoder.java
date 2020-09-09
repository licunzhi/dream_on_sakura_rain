package org.example.hello;

import com.ailk.aus.tool.sm2Cryptor.Sm2Cryptor;

/**
 * @ClassName DeEncoder
 * @function [业务功能]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/08/17 17:13
 */
public class DeEncoder {
    public static void main(String[] args) {

        String text = "BOZmQkDHsp85vZ0RrGpqsO8QG63qqfMiQtHRnnMYQYo4J6K2TaNrjbqbM3sWEStjmRrviKRgJqhfERdDj3qIASDrf6QTnt234tjHGLkRdlu4lqFDVHBAzF9QNTPUQ85upm0DBXk";
//        String text = "123123";
        System.out.println(Sm2Cryptor.decrypt(text));
    }
}
