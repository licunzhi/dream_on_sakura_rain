package dream.sakura.rain.utils;

import com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @ClassName XmlUtils
 * @Description xml工具类
 * @Author lcz
 * @Date 2020/01/20 09:51
 */
public class XmlUtils {

    /**
     * 需要使用依赖pom坐标 此方法不需要对应实体类即可转换
     * <dependency>
     *      <groupId>org.json</groupId>
     *      <artifactId>json</artifactId>
     *      <version>20180130</version>
     * </dependency>
     */
    public static String xmlConvertJson() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                +"<user>"
                + "<user-id>12280</user-id>"
                + "<user-name>licunzhi</user-name>"
                + "<user-age>13</user-age>"
                + "<user-sex>1</user-sex>"
                + "</user>";
        JSONObject jsonObject = XML.toJSONObject(xml);
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }

    /**
     * 将XML转为指定的POJO
     *
     * @param clazz 转换类型
     * @param xmlStr 带解析字符串
     * @return 出参
     */
    public static Object xmlStrToOject(Class<?> clazz, String xmlStr) {
        try {
            xmlStr = xmlStr.replaceAll("\\t", "");
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Reader reader = new StringReader(xmlStr);
            Object xmlObject = unmarshaller.unmarshal(reader);
            reader.close();
            return xmlObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param object
     * @return
     * @throws Exception
     */
    public static String objectToXmlStr(Object object) {
        try {
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshal = context.createMarshaller();
            // 格式化输出
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // 编码格式,默认为GBK
            marshal.setProperty(Marshaller.JAXB_ENCODING, "GBK");
            // 是否省略xml头信息
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshal.setProperty("jaxb.encoding", "GBK");
            marshal.setProperty("com.sun.xml.internal.bind.marshaller.CharacterEscapeHandler",
                    (CharacterEscapeHandler) (ch, start, length, isAttVal, writer1) -> writer1.write(ch, start, length));
            marshal.marshal(object, writer);
            return new String(writer.getBuffer());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
