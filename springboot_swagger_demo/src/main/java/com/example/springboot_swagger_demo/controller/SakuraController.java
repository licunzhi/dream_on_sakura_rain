package com.example.springboot_swagger_demo.controller;


import com.example.springboot_swagger_demo.domain.Sakura;
import com.example.springboot_swagger_demo.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sakura")
@Api(value = "sakura基础数据接口", tags = "接口标识") //这里可以不设置，默认的展示效果是该类的名称SakuraController
public class SakuraController {

    static Map<String, Sakura> sakuras = new HashMap<>();

    @ApiOperation(value = "创建一个sakura", notes = "对接口的功能备注解释")//接口功能解释
    @ApiImplicitParams( {// 多个参数的提示的展示方式，也可以单独只使用一个@ApiImplicitParam
                    //@ApiImplicitParam(name = "id", value = "用户ID", dataType = "Long", paramType = "path"),//点进注解，会有paramType的其它选项和用法解释
                    @ApiImplicitParam(name = "sakura", value = "sakura实体类", required = true, dataType = "Sakura")//参数解释
    })
    @ApiResponses(value = {// 多个返回的提示的展示方式，也可以单独只使用一个@ApiImplicitParam
                    @ApiResponse(code = 401, message = "未未授权"), @ApiResponse(code = 500, message = "server error"),
                    @ApiResponse(code = 200, message = "success", response = ResponseData.class)})
    @PostMapping
    public Object addRequest(@RequestBody Sakura sakura) {
        sakuras.put(sakura.getId(), sakura);
        return "success";
    }

    @ApiOperation(value = "获取sakura信息", notes = "返回sakura所有信息")
    @GetMapping
    public Object getRequest() {
        return sakuras.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }


    @ApiIgnore//注解标识不展示在swagger界面上
    @PutMapping
    public String putRequest() {
        return "response put result message";
    }
}
