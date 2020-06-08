package main.sakura_rain.seven.Bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Team
 * @function [团队概念]
 * @notice 持久化操作不做业务上处理
 * @Author lcz
 * @Date 2020/06/05 14:28
 */
public class Team implements Serializable {

    private static final long serialVersionUID = 1247159351829610481L;

    private String name;
    private String desc;
    private String requestType;
    private String requestUrl;

    private List<Map<String, String>> headers;
    private List<Map<String, String>> querys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public List<Map<String, String>> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Map<String, String>> headers) {
        this.headers = headers;
    }

    public List<Map<String, String>> getQuerys() {
        return querys;
    }

    public void setQuerys(List<Map<String, String>> querys) {
        this.querys = querys;
    }
}
