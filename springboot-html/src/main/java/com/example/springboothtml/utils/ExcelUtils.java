package com.example.springboothtml.utils;

import com.example.springboothtml.domain.ListData;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * @author licunzhi
 * @desc 统计分析报表操作工具类
 * @date 2018-10-28
 */
public class ExcelUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

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
                    List<ListData.Mods.Item.Data.Auction> dataList, String sheetName, Boolean picture) {

        //创建单元格样式
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setWrapText(true);

        // 读取图表
        HSSFSheet chart = hssfWorkbook.getSheet(sheetName);
        HSSFPatriarch patriarch = chart.createDrawingPatriarch();

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


        for (int i = 0; i < 12; i++) {
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
            cpuRowCell.setCellValue(auction.getView_sales().replace("人收货", ""));
            cpuRowCell.setCellStyle(cellStyle);

            HSSFCell nicks = labelRow.createCell(4);
            nicks.setCellValue(auction.getNick());
            nicks.setCellStyle(cellStyle);

            HSSFCell pics = labelRow.createCell(5);
            pics.setCellValue(auction.getPic_url());
            pics.setCellStyle(cellStyle);

            HSSFCell comment = labelRow.createCell(6);
            comment.setCellValue(auction.getComment_url());
            comment.setCellStyle(cellStyle);

            HSSFCell shopLink = labelRow.createCell(7);
            shopLink.setCellValue(auction.getShopLink());
            shopLink.setCellStyle(cellStyle);

            HSSFCell detail = labelRow.createCell(8);
            detail.setCellValue(auction.getDetail_url());
            detail.setCellStyle(cellStyle);

            if (picture) {
                picAgain(hssfWorkbook, patriarch, i, auction);
            }

            /*分析是不是金牌卖家和天猫店家*/
            goldOrTmall(labelRow, cellStyle, auction);

            i++;
        }

        return hssfWorkbook;
    }

    private static void picAgain(HSSFWorkbook hssfWorkbook, HSSFPatriarch patriarch, int i,
                    ListData.Mods.Item.Data.Auction auction) {
        try {
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) 9, i, (short) 9, i);
            anchor.setAnchorType(0);
            URL url = new URL("https:" + auction.getPic_url());
            /*BufferedImage bufferImg = ImageIO.read(url);*/

            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }

            /*ImageIO.write(bufferImg, "jpg", byteArrayOut);*/
            byte[] data = output.toByteArray();
            patriarch.createPicture(anchor, hssfWorkbook.addPicture(data, HSSFWorkbook.PICTURE_TYPE_JPEG));
            dataInputStream.close();
            output.close();
            LOGGER.info("获取商品{}图片成功", auction.getRaw_title());
        } catch (IOException e) {
            System.out.println("未获取成功的图片url：" + auction.getRaw_title());
        } catch (Exception e) {
            System.out.println("未获取成功的图片url：" + auction.getPic_url());
        }
    }

    private static void goldOrTmall(HSSFRow labelRow, HSSFCellStyle cellStyle,
                    ListData.Mods.Item.Data.Auction auction) {
        List<ListData.Mods.Item.Data.Auction.Icon> icons = auction.getIcon();
        String jinpai = "";
        String tMall = "";
        if (icons != null && !icons.isEmpty()) {
            if (icons.stream().anyMatch(icon -> icon.getDom_class().equals("icon-service-jinpaimaijia"))) {
                jinpai = "是";
            }
            if (icons.stream().anyMatch(icon -> icon.getDom_class().equals("icon-service-tianmao"))) {
                tMall = "是";
            }
        }
        HSSFCell jinpaiCell = labelRow.createCell(10);
        jinpaiCell.setCellValue(jinpai);
        jinpaiCell.setCellStyle(cellStyle);

        HSSFCell tMallCell = labelRow.createCell(11);
        tMallCell.setCellValue(tMall);
        tMallCell.setCellStyle(cellStyle);

    }
}
