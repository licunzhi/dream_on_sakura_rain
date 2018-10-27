package com;

import com.sakura.util.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

public class github_demo {
    public static void main(String[] args) throws Exception {
        String inFile = "tpl_pie.xls"; // 模板文件
        String outFile = "D:/out_pie.xls"; // 输出文件

        //数据指标
        Map<String, Integer> dataMap = new LinkedHashMap<>();
        dataMap.put("0-20%", 12);
        dataMap.put("20-40%", 12);
        dataMap.put("40-60%", 12);
        dataMap.put("60-80%", 12);
        dataMap.put("80%~", 12);
        dataMap.put("其他", 12);

        String filePath = github_demo.class.getClassLoader().getResource(inFile).getFile();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
        HSSFWorkbook result = ExcelUtils.createPieChart(hssfWorkbook, "虚拟机使用率", dataMap, "图表");
        FileOutputStream fileOutputStream = new FileOutputStream(outFile);
        result.write(fileOutputStream);
        System.out.println("输出文件 " + outFile);
    }
}
