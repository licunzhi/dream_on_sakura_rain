package com.example.vue.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ResponseBean
 * @Description 返回体
 * @Author lcz
 * @Date 2019/07/04 09:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean<T> {
    private Integer code;
    private String message;
    private T data;
}
