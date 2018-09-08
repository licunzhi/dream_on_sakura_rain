package com.sakura.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author licunzhi
 * @desc 测试注解@Getter @Setter使用
 * @date 2018-09-10
 */
public class PersonGetterSetter {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Integer age;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private Double salary;
}
