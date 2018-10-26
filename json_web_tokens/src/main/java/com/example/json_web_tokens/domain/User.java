package com.example.json_web_tokens.domain;

import lombok.Data;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-10-14
 */
@Data
public class User {
    private String name;
    private String password;
    private String address;
    private String email;
    private Integer roleId;

}
