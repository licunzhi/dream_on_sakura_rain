package dream.sakura.rain;

import dream.sakura.rain.bean.SmsRepBean;
import dream.sakura.rain.utils.XmlUtils;

/**
 * @ClassName TestMain
 * @Description 测试主类
 * @Author lcz
 * @Date 2020/01/20 09:50
 */
public class TestMain {
    public static void main(String[] args) {
        String xmlConvertJson = XmlUtils.xmlConvertJson();
        System.out.println(xmlConvertJson);

        String xmlStr = XmlUtils.objectToXmlStr(new SmsRepBean());
        System.out.println(xmlStr);


        Object xmlStrToOject = XmlUtils.xmlStrToOject(SmsRepBean.class, xmlStr);
        System.out.println(xmlStrToOject);
    }
}
