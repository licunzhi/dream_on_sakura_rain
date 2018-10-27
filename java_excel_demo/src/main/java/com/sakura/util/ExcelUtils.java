package com.sakura.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.List;
import java.util.Map;

public class ExcelUtils {

    /**
     * 创建excel饼图表(数据驱动图表形成)
     *
     * @param hssfWorkbook 对象
     * @param title        标题
     * @param dataMap      数据对
     * @param sheetName    表名称
     * @return 完善之后
     */
    public static HSSFWorkbook createPieChart(HSSFWorkbook hssfWorkbook, String title, Map<String, Integer> dataMap,
                    String sheetName) {
        // 读取模板
        //创建单元格样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setWrapText(true);

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

        return hssfWorkbook;
    }

    /**
     * 普通数据表填充
     *
     * @param hssfWorkbook
     * @param title
     * @param dataMap
     * @param sheetName
     * @return
     */
    public static HSSFWorkbook createDataSheet(HSSFWorkbook hssfWorkbook, String title,
                    Map<String, List<String>> dataMap, String sheetName) {
        // 读取模板
        //创建单元格样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setWrapText(true);

        // 读取图表
        HSSFSheet chart = hssfWorkbook.getSheet(sheetName);

        //数据填充
        int i = 1;
        for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
            HSSFRow labelRow = chart.createRow(i);
            List<String> values = entry.getValue();
            for (int j = 0; j < values.size(); j++) {
                HSSFCell valueRowCell = labelRow.createCell(j);
                valueRowCell.setCellValue(values.get(j));
                valueRowCell.setCellStyle(cellStyle);
            }
            i++;
        }

        return hssfWorkbook;
    }
}
