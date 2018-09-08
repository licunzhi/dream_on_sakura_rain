package com.sakura.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author licunzhi
 * @desc @ToString
 * @date 2018-09-10
 */
@ToString
@Data
public class PersonToString {
    private String name;
    private Integer age;
    private String address;
    private Double salary;
}
