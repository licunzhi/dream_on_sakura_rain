package com.example.springboothtml.utils;

import com.example.springboothtml.domain.ListData;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.List;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 统计分析报表操作工具类
 * @date 2018-10-28
 */
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
    public static HSSFWorkbook createPieChart(HSSFWorkbook hssfWorkbook, String title, String charMessage,
                    Map<String, Integer> dataMap, String sheetName, Integer index) {
        //创建单元格样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setWrapText(true);

        // 读取图表
        HSSFSheet chart = hssfWorkbook.getSheet(sheetName);

        if (charMessage != null) {
            HSSFCell messageCell = chart.getRow(index).getCell(0);
            messageCell.setCellValue(charMessage);
        }
        index++;

        //设置标题
        if (title != null) {
            HSSFCell titleCell = chart.getRow(index).getCell(0);
            titleCell.setCellValue(title);
        }
        index++;

        //数据填充
        for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
            HSSFRow labelRow = chart.getRow(index);
            HSSFCell labelRowCell = labelRow.getCell(0);
            labelRowCell.setCellValue(entry.getKey());
            labelRowCell.setCellStyle(cellStyle);
            HSSFCell valueRowCell = labelRow.getCell(1);
            valueRowCell.setCellValue(entry.getValue());
            valueRowCell.setCellStyle(cellStyle);
            index++;
        }

        return hssfWorkbook;
    }

    /**
     * 创建数据sheet（填充格式不满足抛出异常）
     *
     * @param hssfWorkbook 对象
     * @param title        标题
     * @param dataList     数据
     * @param sheetName    表名称
     * @return 完善之后
     */
    public static HSSFWorkbook createDataSheet(HSSFWorkbook hssfWorkbook, String title,
                    List<ListData.Mods.Item.Data.Auction> dataList, String sheetName) {

        //创建单元格样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setWrapText(true);

        // 读取图表
        HSSFSheet chart = hssfWorkbook.getSheet(sheetName);

        // 标题背景色设置
        HSSFFont titleFont = hssfWorkbook.createFont();
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleFont.setFontHeightInPoints((short) 12);
        titleFont.setFontName("宋体");
        HSSFCellStyle titleStyle = hssfWorkbook.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setBorderTop(CellStyle.BORDER_THIN);
        titleStyle.setBorderBottom(CellStyle.BORDER_THIN);
        titleStyle.setBorderLeft(CellStyle.BORDER_THIN);
        titleStyle.setBorderRight(CellStyle.BORDER_THIN);
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleStyle.setWrapText(true);
        titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);


        for (int i = 0; i < 4; i++) {
            chart.getRow(0).getCell(i).setCellStyle(titleStyle);
        }

        //数据填充
        int i = 1;
        for (ListData.Mods.Item.Data.Auction auction : dataList) {
            HSSFRow labelRow = chart.createRow(i);
            HSSFCell indexRowCell = labelRow.createCell(0);
            indexRowCell.setCellValue(i);
            indexRowCell.setCellStyle(cellStyle);

            HSSFCell valueRowCell = labelRow.createCell(1);
            valueRowCell.setCellValue(auction.getRaw_title());
            valueRowCell.setCellStyle(cellStyle);

            HSSFCell ipRowCell = labelRow.createCell(2);
            ipRowCell.setCellValue(auction.getView_price());
            ipRowCell.setCellStyle(cellStyle);

            HSSFCell cpuRowCell = labelRow.createCell(3);
            cpuRowCell.setCellValue(auction.getView_sales());
            cpuRowCell.setCellStyle(cellStyle);

            i++;
        }

        return hssfWorkbook;
    }
}
