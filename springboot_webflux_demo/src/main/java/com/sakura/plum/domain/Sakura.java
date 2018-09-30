package com.sakura.plum.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

/**
 * @author licunzhi
 * @desc 描述功能
 * @date 2018-09-29
 */
@Data
@ToString
public class Sakura {

    private String id;
    private String name;
    private Date time;

    public Sakura() {
    }

    public Sakura(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.time = new Date();
    }
}
