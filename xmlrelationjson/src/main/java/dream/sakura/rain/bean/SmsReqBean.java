package dream.sakura.rain.bean;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName SmsReqBean
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2020/01/08 17:43
 */
@Data
@ToString
@XmlRootElement(name = "operation_in")
public class SmsReqBean {
    private String service_name = "";
    private String sysfunc_id = "";
    private String request_time = "";
    private String verify_code = "";
    private String request_source = "";
    private String need_return = "";
}
