package com.sakura.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.Map;

public class ExcelUtils {

    public static HSSFWorkbook createPieChart(HSSFWorkbook hssfWorkbook, String title, Map<String, Integer> dataMap, String sheetName) {
        // 读取模板
        try {
            //创建单元格样式
            HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cellStyle.setWrapText(true);

            //创建标题样式
            HSSFCellStyle cellTitleStyle = hssfWorkbook.createCellStyle();
            cellTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            cellTitleStyle.setWrapText(true);

            // 读取图表
            HSSFSheet chart = hssfWorkbook.getSheet(sheetName);


            //设置标题
            HSSFCell titleCell = chart.getRow(0).getCell(0);
            titleCell.setCellValue(title);

            //数据填充
            int i = 1;
            for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
                HSSFRow labelRow = chart.getRow(i);
                HSSFCell labelRowCell = labelRow.getCell(0);
                labelRowCell.setCellValue(entry.getKey());
                HSSFCell valueRowCell = labelRow.getCell(1);
                valueRowCell.setCellValue(entry.getValue());
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hssfWorkbook;
    }
}
