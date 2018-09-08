package com.sakura.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author licunzhi
 * @desc @EqualsAndHashCode equals方法
 * @date 2018-09-10
 */
@EqualsAndHashCode
@Data
public class PersonHashCode {
    private  String name;
    private Integer age;
    private String address;
    private Double salary;
}
