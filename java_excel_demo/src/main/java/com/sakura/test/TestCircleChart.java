package com.sakura.test;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.SortOrder;

import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCircleChart {
    public static void main(String[] args) {

        // excel2003工作表
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Sheet 1");

        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

        // 设置具体数据
        List<String> timeList = new ArrayList<String>();
        timeList.add("10:00");
        timeList.add("11:00");
        timeList.add("12:00");
        List<Integer> appList = new ArrayList<Integer>();
        appList.add(120);
        appList.add(200);
        appList.add(150);
        List<Integer> oraList = new ArrayList<Integer>();
        oraList.add(230);
        oraList.add(200);
        oraList.add(235);
        // 设置图片中的字体和颜色以及字号
        Font titleFont = new Font("黑体", Font.BOLD, 24);
        Font xfont = new Font("黑体", Font.BOLD, 10);
        Font labelFont = new Font("黑体", Font.BOLD, 10);
        // 设置数据区域
        DefaultPieDataset  pieDataset = new DefaultPieDataset();
        for (int i = 0; i < timeList.size(); i++) {
            pieDataset.setValue("0-20%", 10);
            pieDataset.setValue("40-60%", 16);
            pieDataset.setValue("20-40%", 20);
            pieDataset.sortByKeys(SortOrder.ASCENDING);
        }
        JFreeChart chart = ChartFactory.createPieChart("虚拟机使用率", pieDataset, true, true, true);
        // 设置图例字体
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 10));
        // 设置标题字体
        chart.setTitle(new TextTitle(chart.getTitle().getText(), titleFont));

        try {
            ChartUtilities.writeChartAsPNG(byteArrayOut, chart, 400, 200);
            HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
            // 八个参数，前四个表示图片离起始单元格和结束单元格边缘的位置，
            // 后四个表示起始和结束单元格的位置，如下表示从第2列到第12列，从第1行到第15行,需要注意excel起始位置是0
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) 2, (short) 1, (short) 15, (short) 20);
            anchor.setAnchorType(3);
            // 插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
            // excel2003后缀
            FileOutputStream fileOut = new FileOutputStream("D://myExcel.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
