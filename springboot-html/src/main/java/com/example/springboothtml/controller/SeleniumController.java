package com.example.springboothtml.controller;

import com.example.springboothtml.domain.ListData;
import com.example.springboothtml.service.SeleniumService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "使用selenium测试实现", tags = "和原有的接口进行剥离")
public class SeleniumController {

    @Autowired
    private SeleniumService seleniumService;

    @ApiOperation(value = "进入登录页面", notes = "扫描二维码进入登录界面")//接口功能解释
    @GetMapping("/login")
    public ResponseEntity login() {
        return seleniumService.login();
    }

    @ApiOperation(value = "定制化点击之后调用这个接口抓取指定页面", notes = "定制化点击之后调用这个接口抓取指定页面", position = -1)//接口功能解释
    @ApiImplicitParams(value = {
                    @ApiImplicitParam(name = "startPage", value = "起始页", required = true, defaultValue = "1", dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "endPage", value = "终止页", required = true, dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "picture", value = "是否抓取图片(默认false)[此操作会导致数据采集速度变慢，误差因素会导致部分图片采集失败]", allowableValues = "false,true", defaultValue = "false", required = true, dataType = "boolean", paramType = "query")})
    @ApiResponses(value = {
                    @ApiResponse(code = 200, message = "成功操作", response = ListData.Mods.Item.Data.Auction.class)})
    @GetMapping("/list/html")
    public ResponseEntity scrapHtml(Integer startPage, Integer endPage, Boolean picture) {
        return seleniumService.scrapHtml(startPage, endPage, picture);
    }

    @ApiOperation(value = "重新加载监控窗口", notes = "重新加载监控窗口")//接口功能解释
    @GetMapping("/relogin")
    public ResponseEntity relogin() {
        return seleniumService.relogin();
    }
}
