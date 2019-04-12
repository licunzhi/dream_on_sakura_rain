package com.meimie.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description 一句话描述功能
 * @Author lcz
 * @Date 2019/04/02 16:15
 */
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -2924724445946917930L;
    private Integer id;
    private String username;
    private String password;
}
