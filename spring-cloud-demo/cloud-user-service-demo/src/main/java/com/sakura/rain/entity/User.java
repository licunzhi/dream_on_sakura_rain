package com.sakura.rain.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author licunzhi
 * @desc 用户实体类
 * @date 2018-11-28
 */
@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 7006081095014858492L;

    private Long id;
    private String name;
    private String db_source;
}
