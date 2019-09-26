package com.park.lcz.main;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ExcelMain
 * @Description excel启动脚本
 * @Author lcz
 * @Date 2019/09/26 11:16
 */
public class ExcelMain {

    public static void main(String[] args) throws IOException {


        String modelPath = ExcelMain.class.getResource("/model/model.xlsx").getFile();
        File file = new File(modelPath);
        XSSFWorkbook xssfSheets = new XSSFWorkbook(new FileInputStream(file));

        XSSFSheet demoSheet = xssfSheets.getSheet("sheet1");
        List<POIXMLDocumentPart> relations = demoSheet.getRelations();

        for (POIXMLDocumentPart dr : relations) {
            if (dr instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture pic = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = pic.getPreferredSize();
                    CTMarker ctMarker = anchor.getFrom();

                }
            }
        }

        xssfSheets.createSheet("licunzhi");
    }
}
