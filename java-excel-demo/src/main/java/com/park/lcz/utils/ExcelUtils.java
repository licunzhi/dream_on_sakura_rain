package com.park.lcz.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.List;

/**
 * 统计分析报表操作工具类
 *
 * poi工具类的封装，适用于一般业务的三段式数据操作：<b>表头|标题|数据</b>
 *
 * <p>
 *  ① {@link #createDataSheet} 支持创建sheet,方法中可以自定义sheet默认全局属性
 * </p>
 * <p>
 *  ② {@link #createDataSheet} 支持创建sheet,方法中可以自定义sheet默认全局属性
 * </p>
 * <p>
 *  ③ {@link #createDataSheet} 支持创建sheet,方法中可以自定义sheet默认全局属性
 * </p>
 *
 * @date 2019-11-06
 * @author licunzhi
 * @version 1.0
 */
public class ExcelUtils {

    /**
     * 创建数据sheet（填充格式不满足抛出异常）
     *
     * @param hssfWorkbook 对象标题
     * @param sheetName    表名称
     * @return 完善之后
     */
    public static HSSFWorkbook createDataSheet(HSSFWorkbook hssfWorkbook, String sheetName) {
        HSSFSheet sheet = hssfWorkbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(30);
        return hssfWorkbook;
    }

    /**
     * 标题数据填充
     */
    public static HSSFWorkbook fillExcelHeader(HSSFWorkbook hssfWorkbook, String sheetName, String title, int index) {
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
        titleStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        titleStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        HSSFSheet sheet = hssfWorkbook.getSheet(sheetName);
        HSSFRow row = sheet.createRow(index);
        HSSFCell cell = row.createCell(0);
        cell.setCellStyle(titleStyle);
        cell.setCellValue(title);
        return hssfWorkbook;
    }

    public static HSSFWorkbook fillExcelTitle(HSSFWorkbook hssfWorkbook, String sheetName, List<String> tableHeaders,
                                           int index) {
        HSSFFont thFont = hssfWorkbook.createFont();
        thFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        thFont.setFontHeightInPoints((short) 10);
        thFont.setFontName("宋体");
        HSSFCellStyle thStyle = hssfWorkbook.createCellStyle();
        thStyle.setFont(thFont);

        HSSFSheet sheet = hssfWorkbook.getSheet(sheetName);
        HSSFRow row = sheet.createRow(index);
        for (int i = 0; i < tableHeaders.size(); i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(thStyle);
            cell.setCellValue(tableHeaders.get(i));
        }
        return hssfWorkbook;
    }

    public static HSSFWorkbook fillExcelData(HSSFWorkbook hssfWorkbook, String sheetName, List<List<String>> tableData,
                                           int index) {
        HSSFFont tdFont = hssfWorkbook.createFont();
        tdFont.setFontHeightInPoints((short) 10);
        tdFont.setFontName("宋体");
        HSSFCellStyle tdStyle = hssfWorkbook.createCellStyle();
        tdStyle.setFont(tdFont);
        HSSFDataFormat format = hssfWorkbook.createDataFormat();
        tdStyle.setDataFormat(format.getFormat("@"));

        HSSFSheet sheet = hssfWorkbook.getSheet(sheetName);
        for (List<String> aTableData : tableData) {
            HSSFRow row = sheet.createRow(index);
            for (int inner = 0; inner < aTableData.size(); inner++) {
                HSSFCell cell = row.createCell(inner);
                cell.setCellStyle(tdStyle);
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(aTableData.get(inner));
            }
            index++;
        }

        return hssfWorkbook;
    }

}
