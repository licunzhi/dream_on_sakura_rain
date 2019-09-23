package com.sakura.rain.utils;

import com.sakura.rain.model.PptModel;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFGroupShape;
import org.apache.poi.xslf.usermodel.XSLFPictureData;
import org.apache.poi.xslf.usermodel.XSLFPictureShape;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName PptUtils
 * @Description create ppt base on ppt model
 * @Author lcz
 * @Date 2019/06/04 09:07
 * @notice java version support 1.8 or later
 */
public class PptUtils {

    public static final int TEXT_DATA = 1;
    public static final int NUMBER_DATA = 1;
    public static final int PICTURE_PATH_DATA = 3;
    public static final int PICTRUE_FILE_DATA = 4;
    public static final int PICTRUE_BASE64_DATA = 5;
    public static final int TABLE_DATA = 6;

    /**
     * @param file    template file @notnull
     * @param dataMap template data information
     * @throws Exception exceptions
     * @desc return file stream to user
     */
    public static XMLSlideShow createPtt(File file, Map<String, PptModel> dataMap) throws Exception {
        /*validate file exist*/
        if (file == null) {
            throw new FileNotFoundException("文件不存在");
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            XMLSlideShow xmlSlideShow = new XMLSlideShow(fileInputStream);
            XSLFSlide[] xmlSlideShowSlides = xmlSlideShow.getSlides();
            for (XSLFSlide xslfSlide : xmlSlideShowSlides) {
                for (XSLFShape shape : xslfSlide.getShapes()) {
                    renderShape(xmlSlideShow, xslfSlide, shape, dataMap);
                }
            }
            PptModel removeList = dataMap.get("removeLis");
            if (removeList != null) {
                String[] removeListArr = removeList.getDataConent().toString().split(",");
                for (String aRemoveListArr : removeListArr) {
                    xmlSlideShow.removeSlide(Integer.parseInt(aRemoveListArr));
                }
            }
//            xmlSlideShow.getSlides()[0].getShapes()[]
            return xmlSlideShow;
        }

    }

    /**
     * @param dataMap template data information
     * @desc inner method
     */
    private static void renderShape(XMLSlideShow xmlSlideShow, XSLFSlide xslfShapes, XSLFShape shape, Map<String, PptModel> dataMap) throws Exception {
        if (shape instanceof XSLFGroupShape) {
            XSLFShape[] shapes = ((XSLFGroupShape) shape).getShapes();
            for (XSLFShape xslfShape : shapes) {
                renderShape(xmlSlideShow, xslfShapes, xslfShape, dataMap);
            }
        } else if (shape instanceof XSLFTextShape) {
            XSLFTextShape txShape = (XSLFTextShape) shape;
            renderShapeContent(xmlSlideShow, xslfShapes, txShape, dataMap);
        } else if (shape instanceof XSLFTable) {
            XSLFTable tableShape = (XSLFTable) shape;
            renderTableContent(xmlSlideShow, xslfShapes, tableShape, dataMap);
        } else {
            System.out.println(shape.getClass());
        }
    }

    /**
     * @param dataMap template data information
     * @desc inner methods
     */
    private static void renderShapeContent(XMLSlideShow xmlSlideShow, XSLFSlide xslfShape, XSLFTextShape shape, Map<String, PptModel> dataMap) throws Exception {
        Set<String> dataKeys = getDataKeys(shape);
        for (String key : dataKeys) {
            key = key.replaceAll("#", "");
            PptModel pptModel = dataMap.get(key);
            int dataType = pptModel.getDataType();
            switch (dataType) {
                case TEXT_DATA:
                    List<XSLFTextParagraph> paragraphList = shape.getTextParagraphs();
                    for (XSLFTextParagraph p : paragraphList) {
                        for (XSLFTextRun textRun : p.getTextRuns()) {
                            String value = (String) (pptModel.getDataConent() == null ? pptModel.getDefaultContent() : pptModel.getDataConent());
                            String text = textRun.getText().replaceAll(key, value).replaceAll("#", "");
                            textRun.setText(text);
                        }
                    }
                    break;
                case PICTURE_PATH_DATA:
                    String value = (String) (pptModel.getDataConent() == null ? pptModel.getDefaultContent() : pptModel.getDataConent());
                    if (value == null) {
                        System.out.println("文件不存在");
                        break;
                    }

                    File image = new File(pptModel.getDataConent().toString());
                    byte[] pictureData = IOUtils.toByteArray(new FileInputStream(image));
                    int idx = xmlSlideShow.addPicture(pictureData, XSLFPictureData.PICTURE_TYPE_JPEG);
                    XSLFPictureShape pic = xslfShape.createPicture(idx);
                    pic.setAnchor(shape.getAnchor());
                    xslfShape.removeShape(shape);
                    break;
                case PICTRUE_FILE_DATA:
                    File file = (File) (pptModel.getDataConent() == null ? pptModel.getDefaultContent() : pptModel.getDataConent());
                    if (file == null) {
                        System.out.println("文件不存在");
                        break;
                    }
                    byte[] pictureFileData = IOUtils.toByteArray(new FileInputStream(file));
                    int idxFile = xmlSlideShow.addPicture(pictureFileData, XSLFPictureData.PICTURE_TYPE_JPEG);
                    XSLFPictureShape picFile = xslfShape.createPicture(idxFile);
                    picFile.setAnchor(shape.getAnchor());
                    xslfShape.removeShape(shape);
                    break;
                case PICTRUE_BASE64_DATA:
                    String base64 = (String) (pptModel.getDataConent() == null ? pptModel.getDefaultContent() : pptModel.getDataConent());
                    if (base64 == null) {
                        System.out.println("base64数据值存在问题");
                        break;
                    }
                    byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(base64);
                    int idxBaseFile = xmlSlideShow.addPicture(decodeBuffer, XSLFPictureData.PICTURE_TYPE_JPEG);
                    XSLFPictureShape picBaseFile = xslfShape.createPicture(idxBaseFile);
                    picBaseFile.setAnchor(shape.getAnchor());
                    xslfShape.removeShape(shape);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * template table data
     */
    private static void renderTableContent(XMLSlideShow xmlSlideShow, XSLFSlide xslfShape, XSLFTable shape, Map<String, PptModel> dataMap) {
        Set<String> dataKeys = getDataKeys(shape);
        for (String key : dataKeys) {
            key = key.replaceAll("#", "");
            PptModel pptModel = dataMap.get(key);
            if (pptModel.getDataType() != TABLE_DATA) {
                return;
            }
            for (XSLFTableRow row : shape.getRows()) {
                for (XSLFTableCell cell : row.getCells()) {
                    cell.getXmlObject();
                    String value = (String) (pptModel.getDataConent() == null ? pptModel.getDefaultContent() : pptModel.getDataConent());
                    String text = cell.getText().replaceAll(key, value).replaceAll("#", "");
                    cell.setText(text);
                    System.out.println(text);
                    System.out.println(cell.getText());
                }
            }
        }
    }


    private static Set<String> getDataKeys(XSLFTextShape shape) {
        String regex = "#[^#]*#";
        Set<String> dataMapKeys = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(shape.getText());
        while (matcher.find()) {
            System.out.println(matcher.group());
            dataMapKeys.add(matcher.group());
        }
        return dataMapKeys;
    }

    private static Set<String> getDataKeys(XSLFTable shape) {
        String regex = "#[^#]*#";
        Set<String> dataMapKeys = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile(regex);
        StringBuilder cellContent = new StringBuilder("");
        shape.getRows().forEach(row -> row.getCells().forEach(cell -> {
            cellContent.append(cell.getText()).append(" ");
        }));
        Matcher matcher = pattern.matcher(cellContent.toString());
        while (matcher.find()) {
            System.out.println(matcher.group());
            dataMapKeys.add(matcher.group());
        }
        return dataMapKeys;
    }
}

