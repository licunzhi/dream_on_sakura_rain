package com.example.springboot_swagger_demo.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data

@ApiModel(value="Sakura",description="sakura对象")
public class Sakura {
    private String id;
    @ApiModelProperty(value="sakura名字",name="name",example="sakura")
    private String name;
    private String address;
    private String email;
    private List<Sakura> childs;
}
