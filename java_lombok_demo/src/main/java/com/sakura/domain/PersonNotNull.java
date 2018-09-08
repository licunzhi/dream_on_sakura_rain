package com.sakura.domain;

import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author licunzhi
 * @desc 测试注解@NoNull
 * @date 2018-09-10
 */
@Data
public class PersonNotNull {
    private String name;
    private Integer age;
    @NonNull
    private List<String> address;
    private Double salary;
}
