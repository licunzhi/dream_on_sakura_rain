package com.example.springboot_swagger_demo.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author licunzhi
 * @desc 异常结果返回
 * @date 2018-03-12
 */
public class ResponseData<T> {
    /**
     * 结果码
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;

    /**
     * 提示信息
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;

    /**
     * 返回数据
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public ResponseData() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseData{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
    }

    /**
     * 返回错误信息
     *
     * @param code    错误码
     * @param message 错误信息
     * @return RestResponse
     */
    public static <T> ResponseData<T> error(Integer code, String message) {
        ResponseData<T> response = new ResponseData<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    /**
     * 返回自定义信息、对象
     *
     * @param code    结果码
     * @param message 信息
     * @param obj     对象
     * @return RestResponse
     */
    public static <T> ResponseData<T> success(Integer code, String message, T obj) {
        ResponseData<T> response = new ResponseData<>();
        response.setCode(code);
        response.setMessage(message);
        response.setData(obj);
        return response;
    }
}
