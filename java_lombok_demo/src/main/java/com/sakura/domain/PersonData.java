package com.sakura.domain;

import lombok.Data;

/**
 * @author licunzhi
 * @desc 测试@Data:不需要写set get方法
 * @date 2018-09-10
 */
@Data
public class PersonData {
    private String name;
    private Integer age;
    private String address;
    private Double salary;
}
