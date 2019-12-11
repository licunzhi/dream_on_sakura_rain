package com.park.lcz.main;

import com.park.lcz.utils.ExcelUtils;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName ExcelMain
 * @Description excel启动脚本
 * @Author lcz
 * @Date 2019/09/26 11:16
 */
public class ExcelMain {

    public static void main(String[] args) throws IOException {


        File file = new File("E:/var/files/66b3531b-6b00-4d2a-8797-660c88a09ff7.pptx");
        ExcelUtils.doPPTtoImage(file);

    }
}
