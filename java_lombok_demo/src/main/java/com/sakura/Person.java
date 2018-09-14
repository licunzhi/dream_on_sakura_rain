package com.sakura;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-14
 */
public class Person {
    private String id;
    private String name;
    private String address;
    private Integer age;
    @NonNull
    @Getter @Setter
    private Double salary;

}
