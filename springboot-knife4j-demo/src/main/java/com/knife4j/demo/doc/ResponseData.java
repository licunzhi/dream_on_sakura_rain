package com.knife4j.demo.doc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : lcz
 * @date : 2020/02/09 10:02
 * @desc : 公共响应data
 * @updator: lcz
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseData<T> {
    /**
     * 0:表示正常返回
     * -1:异常，异常信息从msg中获取
     */
    private int code = 0;
    private String currentTime;
    private String msg = "success";
    private String version = "1.0";
    public T data = null;

    public ResponseData() {
        Date timeInfo = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(timeInfo);
        this.currentTime = dateString;
    }
    public ResponseData(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponseData(int code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
