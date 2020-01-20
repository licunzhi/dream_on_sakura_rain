package dream.sakura.rain.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName NoTemplateRepBean
 * @Description 无模板请求应答
 * @Author lcz
 * @Date 2020/01/08 16:46
 */
@Data
@XmlRootElement(name = "accept_out")
public class SmsRepBean {

    private OrderContent order_content;

    @Data
    public static class OrderContent {
        private String resp_result;
        private String resp_code;
        private String resp_desc;
    }

}
