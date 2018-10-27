package com.sakura.test;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.util.List;

public class BaseExcel {

    /**
     * 图表生成
     *
     * @param title
     * @param labels
     * @param values
     * @param inFile
     * @return
     */
    public static HSSFWorkbook createChart(String title, List<String> labels, List<Integer> values, String inFile) {
        HSSFWorkbook hssfWorkbook = null;
        String filePath = BaseExcel.class.getClassLoader().getResource(inFile).getFile();
        // 读取模板
        try (FileInputStream is = new FileInputStream(filePath)) {
            hssfWorkbook = new HSSFWorkbook(is);
            //创建单元格样式
            HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cellStyle.setWrapText(true);
            // 读取图表
            HSSFSheet chart = hssfWorkbook.getSheet("图表");


            //设置标题
            HSSFCell titleCell = chart.getRow(0).getCell(0);
            titleCell.setCellValue(title);
            System.out.println("设置图表标题" + title);


            //定义标签名称
            for (int i = 1; i <= labels.size(); i++) {
                HSSFRow labelRow = chart.getRow(i);
                HSSFCell hssfCell = labelRow.getCell(0);
                hssfCell.setCellValue(labels.get(i - 1));
                hssfCell.setCellStyle(cellStyle);
            }

            // 数据项目
            for (int i = 1; i <= values.size(); i++) {
                HSSFRow valueRow = chart.getRow(i);
                HSSFCell hssfCell = valueRow.getCell(1);
                hssfCell.setCellValue(values.get(i - 1));
                hssfCell.setCellStyle(cellStyle);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 输出文件
        return hssfWorkbook;
    }
}
