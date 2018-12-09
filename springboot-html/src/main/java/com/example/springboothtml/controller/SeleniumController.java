package com.example.springboothtml.controller;

import com.example.springboothtml.service.SeleniumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licunzhi
 * @desc 使用selenium实现
 * @date 2018-11-17
 */
@RequestMapping("/selenium")
@RestController
@Api(value = "使用selenium测试实现", tags = "使用selenium测试实现")
public class SeleniumController {

    @Autowired
    private SeleniumService seleniumService;

    @ApiOperation(value = "selenium的功能测试", notes = "功能测试基础展示代码：百度主页搜索")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "query", value = "百度首页搜索的关键字", defaultValue = "孟俊才", required = true, dataType = "String", paramType = "query")})
    @GetMapping("/demo_use")
    public ResponseEntity demoUse(String query) {
        return seleniumService.demoUse(query);
    }
}
