package com.park.lcz.bean;

/**
 * ppt参数缓冲对象,通过定义对象中{@link #dataType}确认参数渲染对应的类型
 * <ul>
 *     <li>1 : 文本|数字</li>
 *     <li>2 : <u>文本|数字</u></li>
 *     <li>1 : 文本或者数字</li>
 * </ul>
 *
 * @ClassName PptModel
 * @Description ppt参数存储类
 * @Author lcz
 * @Date 2019/06/18 09:43
 * @notice: @dataType 1 text or number data 文本或者数字
 *                    3 picture dataContent is picture path 图片路径
 *                    4 picture dataContent is picture file 文件类型
 *                    5 picture dataContent is base64 code base64位数据
 *                    6 table
 *           PptUtils can find enum type
 */
public class PptModel<T> {
    private String dataId;
    private int dataType;
    private T dataContent;
    private T defaultContent;

    public PptModel() {
    }

    public PptModel(String dataId, int dataType, T dataContent, T defaultContent) {
        this.dataId = dataId;
        this.dataType = dataType;
        this.dataContent = dataContent;
        this.defaultContent = defaultContent;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public T getDataContent() {
        return dataContent;
    }

    public void setDataContent(T dataContent) {
        this.dataContent = dataContent;
    }

    public T getDefaultContent() {
        return defaultContent;
    }

    public void setDefaultContent(T defaultContent) {
        this.defaultContent = defaultContent;
    }

    @Override
    public String toString() {
        return "PptModel{" +
                "dataId='" + dataId + '\'' +
                ", dataType=" + dataType +
                ", dataContent=" + dataContent +
                ", defaultContent=" + defaultContent +
                '}';
    }
}
